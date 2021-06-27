// g++ -g ./src/AST.cpp -I./inc `llvm-config --cxxflags --ldflags --libs` -c -o ./obj/AST.o
#include <APP.hpp>
#include <AST.hpp>

AstID BaseAST::getValueID() const {
    return ID;
}

/**
 * 変数宣言を表すAST
 */
std::string VariableDeclAST::getName(){
    return Name;
}

bool VariableDeclAST::setDeclType(DeclType type){
    Type = type;
    return true;
}

VariableDeclAST::DeclType VariableDeclAST::getType(){
    return Type;
}

/**
 * 二項演算を表すAST
 */
std::string BinaryExprAST::getOp(){
    return Op;
}
BaseAST* BinaryExprAST::getLHS(){
    return LHS;
}

BaseAST *BinaryExprAST::getRHS(){
    return RHS;
}

/**
 * 関数呼び出しを表すAST
 */
std::string CallExprAST::getCallee(){
    return Callee;
}

BaseAST* CallExprAST::getArgs(int i){
    if (i < Args.size()) {
        return Args.at(i);
    } else {
        return NULL;
    }
}

/**
 * ジャンプ（現状、returnのみ）を表すAST
 */
BaseAST* JumpStmtAST::getExpr(){
    return Expr;
}

/**
 * 変数参照を表すAST
 */
std::string VariableAST::getName(){
    return Name;
}       

/**
 * 整数を表すAST
 */
int NumberAST::getNumberValue(){
    return Val;
}

/**
 * 5.10 モジュールと関数
 * 関数宣言を表すAST
 */
std::string PrototypeAST::getName(){
    return Name;
}

std::string PrototypeAST::getParamName(int i){
    if (i < Params.size()) {
        return Params.at(i);
    } else {
        return NULL;
    }
}

int PrototypeAST::getParamNum(){
    return Params.size();
}

/**
 * 関数定義本体（ボディ）を表すAST
 */
bool FunctionStmtAST::addStatement(BaseAST *stmt){
    StmtLists.push_back(stmt);
    return true;
}

VariableDeclAST* FunctionStmtAST::getVariableDecl(int i){
    if (i < VariableDecls.size()){
        return VariableDecls.at(i);
    } else {
        return NULL;
    }
}

BaseAST* FunctionStmtAST::getStatement(int i){
    if (i < StmtLists.size()){
        return StmtLists.at(i);
    } else {
        return NULL;
    }
}

/**
 * 関数定義を表すAST
 */
std::string FunctionAST::getName(){
    return Proto->getName();
}

PrototypeAST* FunctionAST::getPrototype(){
    return Proto;
}

FunctionStmtAST* FunctionAST::getBody(){
    return Body;
}

/**
 * モジュール（ソースコード）を表すAST
 */
bool TranslationUnitAST::addPrototype(PrototypeAST *proto){
    Prototypes.push_back(proto);

    return true;
}

bool TranslationUnitAST::addFunction(FunctionAST *func){
    Functions.push_back(func);

    return true;
}

PrototypeAST* TranslationUnitAST::getPrototype(int i){
    // 定義されていれば、そのプロトタイプ宣言を返す
    if (i < Prototypes.size()){ 
        return Prototypes.at(i);
    } else {    // 定義されていなければ、NULLを返す
        return NULL;
    }
}

FunctionAST* TranslationUnitAST::getFunction(int i){
    // 定義されていれば、その関数定義を返す
    if (i < Functions.size()){ 
        return Functions.at(i);
    } else {    // 定義されていなければ、NULLを返す
        return NULL;
    }
}

