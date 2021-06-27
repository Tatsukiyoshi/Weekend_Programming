#ifndef AST_HPP
#define AST_HPP

#include <string>
#include <vector>
#include <llvm/Support/Casting.h>
/**
 * 5.9 各種ステートメントのAST(Abstract Syntax Tree)
 * ASTの種類
 */
enum AstID {
    BaseID,
    VariableDeclID,
    BinaryExprID,
    // 5.22 AstIDの修正とNullExprAST
    NullExprID, // 何もしないAST
    CallExprID,
    JumpStmtID,
    VariableID,
    NumberID
};

/**
 * ASTの基底クラス
 */
class BaseAST {
    private:
        AstID ID;

    public:
        BaseAST(AstID id):ID(id){}
        virtual ~BaseAST(){}
        AstID getValueID() const;
};

/**
 * 変数宣言を表すAST
 */
class VariableDeclAST : public BaseAST {
    public:
        // 変数宣言の種類
        typedef enum {
            param,
            local
        } DeclType;

    private:
        std::string Name;
        DeclType Type;

    public:
        VariableDeclAST(const std::string &name) : BaseAST(VariableDeclID), Name(name){}
        ~VariableDeclAST(){}

        // VariableDeclASTなのでtrueを返す
        static inline bool classof(VariableDeclAST const*){
            return true;
        }

        // 渡されたBaseASTクラスがVariableDeclASTか判定する
        static inline bool classof(BaseAST const* base){
            return base->getValueID() == VariableDeclID;
        }

        // 変数名を取得する
        std::string getName();

        // 変数の宣言種別を設定する
        bool setDeclType(DeclType type);

        // 変数の宣言種別を取得する
        DeclType getType();
};

/**
 * 二項演算を表すAST
 */
class BinaryExprAST : public BaseAST {
    private:
        std::string Op;
        BaseAST *LHS, *RHS;

    public:
        // コンストラクタ
        BinaryExprAST(std::string op, BaseAST *lhs, BaseAST *rhs)
            : BaseAST(BinaryExprID), Op(op), LHS(lhs), RHS(rhs){}
        // デストラクタ
        ~BinaryExprAST(){SAFE_DELETE(LHS); SAFE_DELETE(RHS);}

        // BinaryExprASTなので、trueを返す
        static inline bool classof(BinaryExprAST const*){
            return true;
        }

        // 渡されたBaseASTがBinaryExprASTか判定する
        static inline bool classof(BaseAST const* base){
            return base->getValueID() == BinaryExprID;
        }

        // 演算子を取得する
        std::string getOp();

        // 左辺値を取得する
        BaseAST* getLHS();

        // 右辺値を取得する
        BaseAST* getRHS();
};

/**
 * 関数呼び出しを表すAST
 */
class CallExprAST : public BaseAST {
    private:
        std::string Callee;
        std::vector<BaseAST*> Args;

    public:
        // コンストラクタ
        CallExprAST(const std::string &callee, std::vector<BaseAST*> &args)
            : BaseAST(CallExprID), Callee(callee), Args(args){}
        // デストラクタ
        ~CallExprAST(){};

        // CallExprASTなのでtrueを返す
        static inline bool classof(CallExprAST const*){
            return true;
        }

        // 渡されたBaseASTがCallExprASTか判定する
        static inline bool classof(BaseAST const* base){
            return base->getValueID() == CallExprID;
        }

        // 呼び出す関数名を取得する
        std::string getCallee();

        // i番目の引数を取得する
        BaseAST* getArgs(int i);
};

/**
 * ジャンプ（現状、returnのみ）を表すAST
 */
class JumpStmtAST : public BaseAST {
    private:
        BaseAST *Expr;

    public:
        // コンストラクタ
        JumpStmtAST(BaseAST *expr) : BaseAST(JumpStmtID), Expr(expr){}
        // デストラクタ
        ~JumpStmtAST(){SAFE_DELETE(Expr);}

        // JumpStmtASTなのでtrueを返す
        static inline bool classof(JumpStmtAST const*){
            return true;
        }

        // 渡されたBaseASTがJumpStmtASTか判定する
        static inline bool classof(BaseAST const* base){
            return base->getValueID() == JumpStmtID;
        }

        // returnで返すExpressionを取得する
        BaseAST* getExpr();
};

/**
 * 変数参照を表すAST
 */
class VariableAST : public BaseAST {
    private:
        // 変数名
        std::string Name;

    public:
        // コンストラクタ
        VariableAST(const std::string &name) : BaseAST(VariableID), Name(name){}
        // デストラクタ
        ~VariableAST(){};

        // VariableASTなのでtrueを返す
        static inline bool classof(VariableAST const*){
            return true;
        }

        // 渡されたBaseASTがVariableASTか判定する
        static inline bool classof(BaseAST const* base){
            return base->getValueID() == VariableID;
        }

        // 変数名を取得する
        std::string getName();
};

/**
 * 整数を表すAST
 */
class NumberAST : public BaseAST {
    private:
        // 整数値
        int Val;

    public:
        // コンストラクタ
        NumberAST(int val) : BaseAST(NumberID), Val(val){}
        // デストラクタ
        ~NumberAST(){};

        // NumberASTなのでtrueを返す
        static inline bool classof(NumberAST const*){
            return true;
        }

        // 渡されたBaseASTがNumberASTか判定する
        static inline bool classof(BaseAST const* base){
            return base->getValueID() == NumberID;
        }

        // このASTが表現する整数値を取得する
        int getNumberValue();
};

/**
 * 5.10 モジュールと関数
 * 関数宣言を表すAST
 */
class PrototypeAST {
    private:
        std::string Name;   // 関数名
        std::vector<std::string> Params;    // 仮引数の変数名

    public:
        PrototypeAST(const std::string &name, const std::vector<std::string> &params)
            : Name(name), Params(params){}
    
        // 関数名を取得する
        std::string getName();

        // i番目の引数名を取得する
        std::string getParamName(int i);

        // 引数の数を取得する
        int getParamNum();
};

/**
 * 関数定義本体（ボディ）を表すAST
 */
class FunctionStmtAST {
    private:
        std::vector<VariableDeclAST*> VariableDecls;
        std::vector<BaseAST*> StmtLists;

    public:
        FunctionStmtAST(){}
        ~FunctionStmtAST(){}

        // 関数に変数を追加する
        bool addVariableDeclaration(VariableDeclAST *vdecl);

        // 関数にステートメントを追加する
        bool addStatement(BaseAST *stmt);

        // i番目の変数を取得する
        VariableDeclAST *getVariableDecl(int i);

        // i番目のステートメントを取得する
        BaseAST *getStatement(int i);
};

/**
 * 関数定義を表すAST
 */
class FunctionAST {
    private:
        PrototypeAST *Proto;    // 関数宣言
        FunctionStmtAST *Body;  // 関数定義本体（ボディ）

    public:
        // コンストラクタ
        FunctionAST(PrototypeAST *proto, FunctionStmtAST *body) : Proto(proto), Body(body) {}
        // デストラクタ
        ~FunctionAST(){}

        // 関数名を取得する
        std::string getName();

        // この関数のプロトタイプ宣言を取得する
        PrototypeAST *getPrototype();

        // この関数の本体（ボディ）を取得する
        FunctionStmtAST *getBody();
};

/**
 * モジュール（ソースコード）を表すAST
 */
class TranslationUnitAST { // 翻訳単位？
    private:
        std::vector<PrototypeAST*> Prototypes;  // 関数宣言
        std::vector<FunctionAST*> Functions;    // 関数定義

    public:
        // コンストラクタ
        TranslationUnitAST(){};
        // デストラクタ
        ~TranslationUnitAST(){};

        // モジュールにプロトタイプ宣言（関数宣言）を追加する
        bool addPrototype(PrototypeAST *proto);

        // モジュールに関数を追加する
        bool addFunction(FunctionAST *func);

        // モジュールが空か判定する
        bool empty();

        // i番目のプロトタイプ宣言を取得する
        PrototypeAST *getPrototype(int i);

        // i番目の関数定義を取得する
        FunctionAST *getFunction(int i);
};

// 5.23 AstIDの修正とNullExprAST
/**
 * ";"を表すAST
 */
class NullExprAST : public BaseAST {
    public:
        NullExprAST() : BaseAST(NullExprID){}
        static inline bool classof(NullExprAST const*){return true;}
        static inline bool classof(BaseAST const* base){
            return base->getValueID() == NullExprID;
        }
};

#endif
