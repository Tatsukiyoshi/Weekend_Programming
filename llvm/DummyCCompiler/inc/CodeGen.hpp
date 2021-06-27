#ifndef CODEGEN_HPP
#define CODEGEN_HPP

// 5.32 CodeGenクラスの宣言
#include <llvm/IR/Function.h>
#include <llvm/IR/Module.h>
#include <llvm/IR/IRBuilder.h>
#include <llvm/IR/Value.h>
#include <llvm/IR/ValueSymbolTable.h>
#include <AST.hpp>
#include <string>
/**
 * コード生成クラス
 */
class CodeGen {
    private:    // privateメンバ
        llvm::Function *CurFunc;      // 現在コード生成中の関数
        llvm::Module *Mod;            // 生成したモジュールを格納
        llvm::IRBuilder<> *Builder;   // LLVM-IRを生成するIRBuilderクラス

    public:     // publicメソッド
        CodeGen();
        ~CodeGen();
        bool doCodeGen(TranslationUnitAST &tunit, std::string name);
        llvm::Module &getModule();

    private:    // privateメソッド
        bool generateTranslationUnit(TranslationUnitAST &tunit, std::string name);
        llvm::Function *generateFunctionDefinition(FunctionAST *func, llvm::Module *mod);
        llvm::Function *generatePrototype(PrototypeAST *proto, llvm::Module *mod);
        llvm::Value *generateFunctionStatement(FunctionStmtAST *func_stmt);
        llvm::Value *generateVariableDeclaration(VariableDeclAST *vdecl);
        llvm::Value *generateStatement(BaseAST *stmt);
        llvm::Value *generateBinaryExpression(BinaryExprAST *bin_expr);
        llvm::Value *generateCallExpression(CallExprAST *call_expr);
        llvm::Value *generateJumpStatement(JumpStmtAST *jump_stmt);
        llvm::Value *generateVariable(VariableAST *var);
        llvm::Value *generateNumber(int value);
};

#endif
