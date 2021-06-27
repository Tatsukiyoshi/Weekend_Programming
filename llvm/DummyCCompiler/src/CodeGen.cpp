// g++ -g ./src/CodeGen.cpp -I./inc `llvm-config --cxxflags --ldflags --libs` -c -o ./obj/CodeGen.o
// 5.33 CodeGenクラスのコンストラクタ
#include <llvm-10/llvm/IR/LLVMContext.h>
#include <APP.hpp>
#include <CodeGen.hpp>
/**
 * コンストラクタ
 */
CodeGen::CodeGen(){
    llvm::LLVMContext context;
    Builder = new llvm::IRBuilder<>(context);
    Mod = NULL;
}

// 5.34 doCodeGen
/**
 * コード生成実行
 * @param  TranslationUnitAST Module名（入力ファイル名）
 * @return 成功時：true 失敗時：false
 */
bool CodeGen::doCodeGen(TranslationUnitAST &tunit, std::string name){
    return generateTranslationUnit(tunit, name);
}

// 5.35 getModule
/**
 * Module取得
 */
llvm::Module &CodeGen::getModule(){
    if(Mod){
        return *Mod;
    } else {
        llvm::LLVMContext context;
        return *(new llvm::Module("null", context));
    }
}

// 5.36 generateTranslationUnit
/**
 * Module生成メソッド
 * @param  TranslationUnitAST Module名（入力ファイル名）
 * @return 成功時：true 失敗時：false
 */
bool CodeGen::generateTranslationUnit(TranslationUnitAST &tunit, std::string name){
    // Moduleを生成
    llvm::LLVMContext context;
    Mod = new llvm::Module(name, context);

    // function declaration
    for(int i = 0; ; i++){
        PrototypeAST *proto = tunit.getPrototype(i);
        if(!proto) break;
        else if(!generatePrototype(proto, Mod)){
            SAFE_DELETE(Mod);
            return false;
        }
    }

    // function definition
    for(int i = 0; ; i++){
        FunctionAST *func = tunit.getFunction(i);
        if(!func) break;
        else if(!generateFunctionDefinition(func, Mod)){
            SAFE_DELETE(Mod);
            return false;
        }
    }
    return true;
}

// 5.37 generatePrototype
/**
 * 関数宣言生成メソッド
 * @param PrototypeAST, Module
 * @return 生成したFunctionのポインタ
 */
llvm::Function *CodeGen::generatePrototype(PrototypeAST *proto, llvm::Module *mod){
    llvm::LLVMContext context;

    // already declared?
    llvm::Function *func = mod->getFunction(proto->getName());
    if(func){
        if(func->arg_size() == proto->getParamNum() && func->empty()){
            return func;
        } else {
            fprintf(stderr, "error::function %s is redefined", proto->getName().c_str());
            return NULL;
        }
    }

    // create arg_types
    std::vector<llvm::Type *> int_types(proto->getParamNum(), llvm::Type::getInt32Ty(context));

    // create func type
    llvm::FunctionType *func_type = llvm::FunctionType::get(llvm::Type::getInt32Ty(context), int_types, false);

    // create function
    func = llvm::Function::Create(func_type, llvm::Function::ExternalLinkage, proto->getName(), mod);

    // set names
    llvm::Function::iterator arg_iter = func->begin();
    for(int i = 0; ; i++){
        arg_iter->setName(proto->getParamName(i).append("_arg"));
        arg_iter++;
    }
    return func;
}

// 5.38 generateFunctionDefinition
/**
 * 関数定義生成メソッド
 * @param FunctionAST Module
 * @return 生成したFunctionのポインタ
 */
llvm::Function *CodeGen::generateFunctionDefinition(FunctionAST *func_ast, llvm::Module *mod){
    llvm::LLVMContext context;

    llvm::Function *func = generatePrototype(func_ast->getPrototype(), mod);
    if(!func) return NULL;

    CurFunc = func;
    llvm::BasicBlock *bblock = llvm::BasicBlock::Create(context, "empty", func);
    Builder->SetInsertPoint(bblock);

    // Functionのボディを生成
    generateFunctionStatement(func_ast->getBody());

    return func;
}

// 5.39 generateFunctionStatement
/**
 * 関数生成メソッド
 * @param FunctionStmtAST
 * @return 最後に生成したValueのポインタ
 */
llvm::Value *CodeGen::generateFunctionStatement(FunctionStmtAST *func_stmt){
    // insert variable decls
    VariableDeclAST *vdecl;
    llvm::Value *v = NULL;

    for(int i = 0; ; i++){
        // 最後まで見たら終了
        if(!func_stmt->getVariableDecl(i)) break;

        // create alloca
        vdecl = dynamic_cast<VariableDeclAST *>(func_stmt->getVariableDecl(i));
        v = generateVariableDeclaration(vdecl);
    }

    // insert expr statement
    BaseAST *stmt;
    for(int i = 0; ; i++){
        // 最後まで見たら終了
        stmt = func_stmt->getStatement(i);
        if(!stmt)
            break;
        else if(!llvm::isa<NullExprAST>(stmt))
            v = generateStatement(stmt);
    }

    return v;
}

// 5.40 generateVariableDeclaration
/**
 * 変数宣言（alloca命令）生成メソッド
 * @param VariableDeclAST
 * @return 生成したValueのポインタ
 */
llvm::Value *CodeGen::generateVariableDeclaration(VariableDeclAST *vdecl){
    llvm::LLVMContext context;

    // create alloca
    llvm::AllocaInst *alloca = Builder->CreateAlloca(llvm::Type::getInt32Ty(context), 0, vdecl->getName());

    // if args alloca
    if(vdecl->getType() == VariableDeclAST::param){
        // store args
        llvm::ValueSymbolTable *vs_table = CurFunc->getValueSymbolTable();
        Builder->CreateStore(vs_table->lookup(vdecl->getName().append("_arg")), alloca);
    }

    return alloca;
}

// 5.41 generateStatement
/**
 * ステートメント生成メソッド
 * 実際にはASTの種別を確認して各種生成メソッドを呼び出し
 * @param JumpStmtAST
 * @return 生成したValueのポインタ
 */
llvm::Value *CodeGen::generateStatement(BaseAST *stmt){
    if(llvm::isa<BinaryExprAST>(stmt)){
        return generateBinaryExpression(dynamic_cast<BinaryExprAST *>(stmt));
    } else if(llvm::isa<CallExprAST>(stmt)){
        return generateCallExpression(dynamic_cast<CallExprAST *>(stmt));
    } else if(llvm::isa<JumpStmtAST>(stmt)){
        return generateJumpStatement(dynamic_cast<JumpStmtAST *>(stmt));
    } else {
        return NULL;
    }
}

// 5.42 generateBinaryExpression
/**
 * 二項演算生成メソッド
 * @param BinaryExprAST
 * @return 生成したValueのポインタ
 */
llvm::Value *CodeGen::generateBinaryExpression(BinaryExprAST *bin_expr){
    BaseAST *lhs = bin_expr->getLHS();
    BaseAST *rhs = bin_expr->getRHS();
    llvm::Value *lhs_v;
    llvm::Value *rhs_v;

    // assignment
    if(bin_expr->getOp() == "="){
        // lhs is variable
        VariableAST *lhs_var = dynamic_cast<VariableAST *>(lhs);
        llvm::ValueSymbolTable *vs_table = CurFunc->getValueSymbolTable();
        lhs_v = vs_table->lookup(lhs_var->getName());
    } else { // other operand
        // lhs => Binary?
        if(llvm::isa<BinaryExprAST>(lhs)){
            lhs_v = generateBinaryExpression(dynamic_cast<BinaryExprAST *>(lhs));
        } else if(llvm::isa<VariableAST>(lhs)){ // lhs -> Variable?
            lhs_v = generateVariable(dynamic_cast<VariableAST *>(lhs));
        } else if(llvm::isa<NumberAST>(lhs)){   // lhs -> Number?
            NumberAST *num = dynamic_cast<NumberAST *>(lhs);
            lhs_v = generateNumber(num->getNumberValue());
        }
    }

    // create rhs value
    if(llvm::isa<BinaryExprAST>(rhs)){
        rhs_v = generateBinaryExpression(dynamic_cast<BinaryExprAST *>(rhs));
    } else if(llvm::isa<CallExprAST>(rhs)){ // rhs -> CallExpression?
        rhs_v = generateCallExpression(dynamic_cast<CallExprAST *>(rhs));
    } else if(llvm::isa<VariableAST>(rhs)){ // rhs -> Variable?
        rhs_v = generateVariable(dynamic_cast<VariableAST *>(rhs));
    } else if(llvm::isa<NumberAST>(rhs)){
        NumberAST *num = dynamic_cast<NumberAST *>(rhs);
        rhs_v = generateNumber(num->getNumberValue());
    }

    if(bin_expr->getOp() == "="){
        // store
        return Builder->CreateStore(rhs_v, lhs_v);
    } else if(bin_expr->getOp() == "+"){
        // add
        return Builder->CreateAdd(lhs_v, rhs_v, "add_tmp");
    } else if(bin_expr->getOp() == "-"){
        // substitute
        return Builder->CreateSub(lhs_v, rhs_v, "sub_tmp");
    } else if(bin_expr->getOp() == "*"){
        // multiply
        return Builder->CreateMul(lhs_v, rhs_v, "mul_tmp");
    } else if(bin_expr->getOp() == "/"){
        // divide
        return Builder->CreateSDiv(lhs_v, rhs_v, "div_tmp");
    } else {
        return NULL;
    }
}

// 5.43 generateCallExpression
/**
 * 関数呼び出し（Call命令）生成メソッド
 * @param CallExprAST
 * @return 生成したValueのポインタ
 */
llvm::Value *CodeGen::generateCallExpression(CallExprAST *call_expr){
    std::vector<llvm::Value *> arg_vec;
    BaseAST *arg;
    llvm::Value *arg_v;
    llvm::ValueSymbolTable *vs_table = CurFunc->getValueSymbolTable();

    for(int i = 0; ; i++){
        if(!(arg = call_expr->getArgs(i))) break;

        if(llvm::isa<CallExprAST>(arg)){            // 関数呼び出しの場合
            arg_v = generateCallExpression(dynamic_cast<CallExprAST *>(arg));
        } else if(llvm::isa<BinaryExprAST>(arg)){   // 二項演算の場合
            BinaryExprAST *bin_expr = dynamic_cast<BinaryExprAST *>(arg);
            arg_v = generateBinaryExpression(dynamic_cast<BinaryExprAST *>(arg));
            if(bin_expr->getOp() == "="){
                VariableAST *var = dynamic_cast<VariableAST *>(bin_expr->getLHS());
                arg_v = Builder->CreateLoad(vs_table->lookup(var->getName()), "arg_val");
            }
        } else if(llvm::isa<VariableAST>(arg)){     // 変数の場合
            arg_v = generateVariable(dynamic_cast<VariableAST *>(arg));
        } else if(llvm::isa<NumberAST>(arg)){       // 定数の場合
            NumberAST *num = dynamic_cast<NumberAST *>(arg);
            arg_v = generateNumber(num->getNumberValue());
        }
        arg_vec.push_back(arg_v);
    }

    return Builder->CreateCall(Mod->getFunction(call_expr->getCallee()), arg_vec, "call_tmp");
}

// 5.44 generateJumpStatement
/**
 * ジャンプ（今回はreturn命令のみ）生成メソッド
 * @param JumpStmtAST
 * @return 生成したValueのポインタ
 */
llvm::Value *CodeGen::generateJumpStatement(JumpStmtAST *jump_stmt){
    BaseAST *expr = jump_stmt->getExpr();
    llvm::Value *ret_v;

    if(llvm::isa<BinaryExprAST>(expr)){
        ret_v = generateBinaryExpression(dynamic_cast<BinaryExprAST *>(expr));
    } else if(llvm::isa<VariableAST>(expr)){
        VariableAST *var = dynamic_cast<VariableAST *>(expr);
        ret_v = generateVariable(var);
    } else if(llvm::isa<NumberAST>(expr)){
        NumberAST *num = dynamic_cast<NumberAST *>(expr);
        ret_v = generateNumber(num->getNumberValue());
    }

    return Builder->CreateRet(ret_v);
}

// 5.45 generateVariable
/**
 * 変数参照（load命令）生成メソッド
 * @param VariableAST
 * @return 生成したValueのポインタ
 */
llvm::Value *CodeGen::generateVariable(VariableAST *var){
    llvm::ValueSymbolTable *vs_table = CurFunc->getValueSymbolTable();

    return Builder->CreateLoad(vs_table->lookup(var->getName()), "var_tmp");
}

// 5.46 generateNumber
/**
 * 定数生成メソッド
 * @param 生成する定数の値
 * @return 精製したValueのポインタ
 */
llvm::Value *CodeGen::generateNumber(int value){
    llvm::LLVMContext context;

    return llvm::ConstantInt::get(llvm::Type::getInt32Ty(context), value);
}
