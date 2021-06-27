// g++ -g ./src/Parser.cpp -I./inc `llvm-config --cxxflags --ldflags --libs` -c -o ./obj/Parser.o
#include <APP.hpp>
#include <lexer.hpp>
#include <AST.hpp>
#include <Parser.hpp>

// 5.12 Parserクラスのpublicメソッド
/**
 * コンストラクタ
 */
Parser::Parser(std::string filename){
    Tokens = LexicalAnalysis(filename);
}

/**
 * 構文解析実行
 * @return 解析成功：true 解析失敗：false
 */
bool Parser::doParse(){
    if(!Tokens){
        // ファイルからトークンが取得できなければ、解析失敗
        fprintf(stderr, "error at lexer\n");
        return false;
    } else
        return visitTranslationUnit();
}

/**
 * 抽象化構文木（AST）取得
 * @return TranslationUnitへの参照
 */
TranslationUnitAST &Parser::getAST(){
    if(TU)
        return *TU;
    else
        return *(new TranslationUnitAST());
}

// 5.13 visitTranslationUnitとvisitExternalDeclaration
/**
 * 翻訳単位（TranslationUnit）用構文解析メソッド
 * @return 解析成功：true 解析失敗：false
 */
bool Parser::visitTranslationUnit(){
    TU = new TranslationUnitAST();

    // ExternalDecl
    while(true){
        if(!visitExternalDeclaration(TU)){
            SAFE_DELETE(TU);
            return false;
        } 
        if(Tokens->getCurType() == TOK_EOF)
            break;
    }
    return true;
}

/**
 * 外部宣言（ExternalDeclaration）用構文解析メソッド
 * 解析したPrototypeとFunctionASTをTranslationUnitに追加
 * @param TranslationUnitAST
 * @return true
 */
bool Parser::visitExternalDeclaration(
    TranslationUnitAST *tunit
){
    // FunctionDeclaration
    PrototypeAST *proto = visitFunctionDeclaration();
    if(proto){
        tunit->addPrototype(proto);
        return true;
    }

    // FunctionDefinition
    FunctionAST *func_def = visitFunctionDefinition();
    if(func_def){
        tunit->addFunction(func_def);
        return true;
    }

    return false;
}

// 5.14 visitFunctionDeclaration
// 5.25 意味解析を実装したvisitFunctionDeclaration
/**
 * 関数宣言（FunctionDeclaration）用構文解析メソッド
 * @return 解析成功：PrototypeAST 解析失敗：NULL
 */
PrototypeAST *Parser::visitFunctionDeclaration(){
    // backup index
    int bkup = Tokens->getCurIndex();
    PrototypeAST *proto = visitPrototype();

    if(!proto){
        return NULL;
    }

    // 終端記号
    if(Tokens->getCurString() == ";"){
        //ここで再定義されていないかを確認
        if(PrototypeTable.find(proto->getName()) != PrototypeTable.end() ||
        (FunctionTable.find(proto->getName()) != FunctionTable.end() &&
        FunctionTable[proto->getName()] != proto->getParamNum() )){
            // エラーメッセージを出してNULLを返す
            fprintf(stderr, "Function: %s is redefined", proto->getName().c_str());
            SAFE_DELETE(proto);
            return NULL;
        }

        // （関数名, 引数）のペアをプロトタイプ宣言テーブル（Map）に追加
        PrototypeTable[proto->getName()] = proto->getParamNum();
        Tokens->getNextToken();
        return proto;
    } else {
        SAFE_DELETE(proto);
        Tokens->applyTokenIndex(bkup);
        return NULL;
    }
}

// 5.15 visitFunctionDefinition
// 5.26 意味解析を実装したvisitFunctionDefinition
/**
 * 関数定義（FunctionDefinition）用構文解析メソッド
 * @return 解析成功：FunctionAST 解析失敗：NULL
 */
FunctionAST *Parser::visitFunctionDefinition(){
    // backup index
    int bkup = Tokens->getCurIndex();
    PrototypeAST *proto = visitPrototype();

    if(!proto){
        return NULL;
    // プロトタイプ宣言と違いがないか、既に関数定義が行われていないか確認
    } else if((PrototypeTable.find(proto->getName()) != PrototypeTable.end() &&
        PrototypeTable[proto->getName()] != proto->getParamNum()) ||
        FunctionTable.find(proto->getName()) != FunctionTable.end()){

        // エラーメッセージを出してNULLを返す
        fprintf(stderr, "Function: %s is redefined", proto->getName().c_str());
        SAFE_DELETE(proto);
        return NULL;
    }

    VariableTable.clear();
    FunctionStmtAST *func_stmt = visitFunctionStatement(proto);

    if(func_stmt){
        // （関数名, 引数の数）のペアを関数テーブル（Map）に追加
        FunctionTable[proto->getName()] = proto->getParamNum();

        return new FunctionAST(proto, func_stmt);
    }
    SAFE_DELETE(proto);
    Tokens->applyTokenIndex(bkup);
    return NULL;
}

// 5.16 変数宣言のチェック
// 5.27 意味解析を実装したvisitPrototype
/**
 * 変数宣言（Prototype）用構文解析メソッド
 * @return 解析成功：PrototypeAST 解析失敗：NULL
 */
PrototypeAST *Parser::visitPrototype(){
   	std::string func_name;

    // backup index
    int bkup = Tokens->getCurIndex();

    // 書籍内で言及なし
	// 関数型（INTのみ）
	if(Tokens->getCurType() == TOK_INT){
		Tokens->getNextToken();
	} else {
		return NULL;
	}

	// 関数名
	if(Tokens->getCurType() == TOK_IDENTIFIER){
		func_name = Tokens->getCurString();
		Tokens->getNextToken();
	} else {
		Tokens->ungetToken(1);	//unget TOK_INT
		return NULL;
	}

	// 左括弧
	if(Tokens->getCurString() == "("){
		Tokens->getNextToken();
	} else {
		Tokens->ungetToken(2);	//unget TOK_INT IDENTIFIER
		return NULL;
	}
    // 書籍内で言及なし（終わり）

    std::vector<std::string> param_list;    // 引数リスト
    bool is_first_param = true;

    while(true){
        // カンマは読み捨てる
        if(!is_first_param && Tokens->getCurType() == TOK_SYMBOL &&
        Tokens->getCurString() == ","){
            Tokens->getNextToken();
        }
        // 型がINTしかないから読み捨てる
        if(Tokens->getCurType() == TOK_INT){
            Tokens->getNextToken();
        } else {
            break;
        }
        if(Tokens->getCurType() == TOK_IDENTIFIER){
            // 引数の変数名に重複がないか確認
            if(std::find(param_list.begin(), param_list.end(), Tokens->getCurString()) != param_list.end()){
                Tokens->applyTokenIndex(bkup);
                return NULL;
            }

            param_list.push_back(Tokens->getCurString());
            Tokens->getNextToken();
        } else {
            Tokens->applyTokenIndex(bkup);
            return NULL;
        }
        // 書籍内で言及なし
		is_first_param = false;
    }
    // 書籍内で省略
	// 右括弧
	if(Tokens->getCurString() == ")"){
		Tokens->getNextToken();
	} else {
		Tokens->applyTokenIndex(bkup);
		return NULL;
	}
    return new PrototypeAST(func_name, param_list);
}

// 5.17 FunctionStatement
// 5.28 意味解析を実装したvisitFunctionStatement
/**
 * FunctionStatement用構文解析メソッド
 * @param 関数名や引数を格納したPrototypeASTクラスのインスタンス
 * @return 解析成功：FunctionStmtAST 解析失敗：NULL
 */
FunctionStmtAST *Parser::visitFunctionStatement(PrototypeAST *proto){
    // backup index
    int bkup = Tokens->getCurIndex();

    if(Tokens->getCurString() == "}"){
        Tokens->getNextToken();
    } else {
        return NULL;
    }

    FunctionStmtAST *func_stmt = new FunctionStmtAST();

    // 引数をfunc_stmtの変数宣言リストに追加
    for(int i = 0; i < proto->getParamNum(); i++){
        VariableDeclAST *vdecl = new VariableDeclAST(proto->getParamName(i));
        vdecl->setDeclType(VariableDeclAST::param);
        func_stmt->addVariableDeclaration(vdecl);
        VariableTable.push_back(vdecl->getName());
    }

    // 書籍内で言及なし／リストなし【Gitから取得したソースで確認】
	VariableDeclAST *var_decl;
	BaseAST *stmt;
	BaseAST *last_stmt;

	if(stmt = visitStatement()){
		while(stmt){
			last_stmt = stmt;
			func_stmt->addStatement(stmt);
			stmt = visitStatement();
		}
    // 書籍内で言及なし（ここまで）
    // 省略
    // 変数があれば、変数宣言リストに追加
    } else if(var_decl = visitVariableDeclaration()){
        while(var_decl){
            var_decl->setDeclType(VariableDeclAST::local);

            // 変数名に重複がないか確認（あった場合、生成した変数名および取得したステートメントを破棄し、NULLを返す）
            if(std::find(VariableTable.begin(), VariableTable.end(), var_decl->getName()) != VariableTable.end()){
                SAFE_DELETE(var_decl);
                SAFE_DELETE(func_stmt);
                return NULL;
            }

            // 変数名テーブルに新しく読み取った変数名を追加
            func_stmt->addVariableDeclaration(var_decl);
            VariableTable.push_back(var_decl->getName());
            var_decl = visitVariableDeclaration();
        }

        BaseAST *stmt, *last_stmt;
        if(stmt = visitStatement()){
            while(stmt){
                last_stmt = stmt;
                func_stmt->addStatement(stmt);
                stmt = visitStatement();
            }
        }
    } else {
        SAFE_DELETE(func_stmt);
        Tokens->applyTokenIndex(bkup);
        return NULL;
    }

    // 最後のステートメントがJumpStmtASTであるか確認
    if(!last_stmt || !llvm::isa<JumpStmtAST>(last_stmt)){
        SAFE_DELETE(func_stmt);
        Tokens->applyTokenIndex(bkup);
        return NULL;
    }

    if(Tokens->getCurString() == "}"){
        Tokens->getNextToken();
        return func_stmt;
    } else {
        SAFE_DELETE(func_stmt);
        Tokens->applyTokenIndex(bkup);
        return NULL;
    }
}

// 5.18 visitAssignmentExpression
// 5.29 意味解析を実装したvisitAssignmentExpression
/**
 * 代入文（AssignmentExpression）用構文解析メソッド
 * @return 解析成功：AST 解析失敗：NULL
 */
BaseAST *Parser::visitAssignmentExpression(){
    // backup index
    int bkup = Tokens->getCurIndex();
    BaseAST *lhs;

    if(Tokens->getCurType() == TOK_IDENTIFIER){
        // 変数が宣言されているか確認
        if(std::find(VariableTable.begin(), VariableTable.end(), Tokens->getCurString()) != VariableTable.end()){
            lhs = new VariableAST(Tokens->getCurString());
            Tokens->getNextToken();

            BaseAST *rhs;
            if(Tokens->getCurType() == TOK_SYMBOL && Tokens->getCurString() == "="){
                Tokens->getNextToken();
                if(rhs = visitAdditiveExpression(NULL)){
                    return new BinaryExprAST("=", lhs, rhs);
                } else {
                    SAFE_DELETE(lhs);
                    Tokens->applyTokenIndex(bkup);
                }
            } else {
                SAFE_DELETE(lhs);
                Tokens->applyTokenIndex(bkup);
            }
        } else {
            Tokens->applyTokenIndex(bkup);
        }
    }
    BaseAST *add_expr = visitAdditiveExpression(NULL);
    if(add_expr){
        return add_expr;
    }

    return NULL;
}

// 5.19 visitPrimaryExpression
// 5.30 意味解析を実装したvisitPrimaryExpression
/**
 * 式の基本構成要素（PrimaryExpression）用構文解析メソッド
 * @return 解析成功：AST 解析失敗：NULL
 */
BaseAST *Parser::visitPrimaryExpression(){
    // backup index
    int bkup = Tokens->getCurIndex();

    // 変数が宣言されていることを確認
    if(Tokens->getCurType() == TOK_IDENTIFIER &&
        (std::find(VariableTable.begin(), VariableTable.end(), Tokens->getCurString())
            != VariableTable.end())){
        std::string var_name = Tokens->getCurString();
        Tokens->getNextToken();
        return new VariableAST(var_name);
    } else if(Tokens->getCurType() == TOK_DIGIT){ // 正の整数
        int val = Tokens->getCurNumVal();
        Tokens->getNextToken();
        return new NumberAST(val);
    } else if(Tokens->getCurType() == TOK_SYMBOL && Tokens->getCurString() == "-"){ // 負の整数
        Tokens->getNextToken();

        int val = Tokens->getCurNumVal() * (-1);
        Tokens->getNextToken();
        return new NumberAST(val);
    }
    return NULL;
}

// 5.20 visitPostfixExpression
// 5.31 意味解析を実装したvisitPostfixExpression
/**
 * 後置式（PostfixExpression）用構文解析メソッド
 * @return 解析成功：AST 解析失敗：NULL
 */
BaseAST *Parser::visitPostfixExpression(){
    // backup index
    int bkup = Tokens->getCurIndex();

    // FUNCTION_IDENTIFIER
    if(Tokens->getCurType() == TOK_IDENTIFIER){
        int param_num;

        // プロトタイプ宣言されているか確認し、引数の数をテーブルから取得
        if(PrototypeTable.find(Tokens->getCurString()) != PrototypeTable.end()){
            param_num = PrototypeTable[Tokens->getCurString()];            
        }
        // 関数定義済みであるか確認し、引数の数をテーブルから取得
        else if(FunctionTable.find(Tokens->getCurString()) != FunctionTable.end()){
            param_num = FunctionTable[Tokens->getCurString()];
        } else {
            return NULL;
        }

        // 関数名取得
        std::string Callee = Tokens->getCurString();
        Tokens->getNextToken();

        // 左括弧
        if(Tokens->getCurType() != TOK_SYMBOL || Tokens->getCurString() != "("){
            Tokens->applyTokenIndex(bkup);
            return NULL;
        }

        Tokens->getNextToken();
        std::vector<BaseAST*> args;
        // 引数を解析
        BaseAST *assign_expr = visitAssignmentExpression();
        if(assign_expr){
            args.push_back(assign_expr);
            // ","が続く限り繰り返し
            while(Tokens->getCurType() == TOK_SYMBOL && 
                Tokens->getCurString() == ","){
                Tokens->getNextToken();
                assign_expr = visitAssignmentExpression();
                if(assign_expr){
                    args.push_back(assign_expr);
                } else {
                    break;
                }
            } // end while
        }

        // 引数の数を確認
        if(args.size() != param_num){
            for(int i = 0; i < args.size(); i++){
                SAFE_DELETE(args[i]);
            }
            Tokens->applyTokenIndex(bkup);
            return NULL;
        }

        // 右括弧
        if(Tokens->getCurType() == TOK_SYMBOL && Tokens->getCurString() == ")"){
            Tokens->getNextToken();
            return new CallExprAST(Callee, args);
        } else {
            for(int i = 0; i < args.size(); i++){
                SAFE_DELETE(args[i]);
            }
            Tokens->applyTokenIndex(bkup);
            return NULL;
        }
    } else {
        return NULL;
    }
}

// 5.21 四則演算
/**
 * 四則演算（AdditiveExpression）用構文解析メソッド
 * @param lhs（左辺）。初回呼び出し時はNULL
 * @return 解析成功：AST 解析失敗：NULL
 */
BaseAST *Parser::visitAdditiveExpression(BaseAST *lhs){
    // backup index
    int bkup = Tokens->getCurIndex();

    if(!lhs)
        // 左辺値を解析
        lhs = visitMultiplicativeExpression(NULL);

    if(!lhs)
        return NULL;

    BaseAST *rhs;
    // 加算+
    if(Tokens->getCurType() == TOK_SYMBOL &&
        Tokens->getCurString() == "+"){
        Tokens->getNextToken();
        rhs = visitMultiplicativeExpression(NULL);
        if(rhs){
            return visitAdditiveExpression(
                new BinaryExprAST("+", lhs, rhs)
            );
        } else {
            SAFE_DELETE(lhs);
            Tokens->applyTokenIndex(bkup);
            return NULL;
        }
    } 
    // 減算-
    else if(Tokens->getCurType() == TOK_SYMBOL &&
        Tokens->getCurString() == "-"){
        Tokens->getNextToken();
        rhs = visitMultiplicativeExpression(NULL);
        if(rhs){
            return visitAdditiveExpression(
                new BinaryExprAST("-", lhs, rhs)
            );
        } else {
            SAFE_DELETE(lhs);
            Tokens->applyTokenIndex(bkup);
            return NULL;
        }
    }
    return lhs;
}
// 5.23 visitExpressionStatement
/**
 * ExpressionStatement用構文解析メソッド
 * @return 解析成功：AST 解析失敗：NULL
 */
BaseAST *Parser::visitExpressionStatement(){
    BaseAST *assign_expr;

    // NULL Expression
    if(Tokens->getCurString() == ";"){
        Tokens->getNextToken();
        return new NullExprAST();
    } else if(assign_expr = visitAssignmentExpression()){
        if(Tokens->getCurString() == ";"){
            Tokens->getNextToken();
            return assign_expr;
        }
    }
    return NULL;
}
