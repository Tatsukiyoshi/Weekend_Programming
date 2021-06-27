#include <string>
#include <vector>
#include <iostream>
#include <fstream>
#include <algorithm>
/**
 * 5.4 Token classの定義
 * トークン種別
 */
enum TokenType {
    TOK_IDENTIFIER, // 識別子
    TOK_DIGIT,      // 数字
    TOK_SYMBOL,     // 記号
    TOK_INT,        // INT
    TOK_RETURN,     // RETURN
    TOK_EOF         // EOF
};

/**
 * 個別トークン格納クラス
 */
class Token {
    private:
    std::string TokenString;
    TokenType Type;
    int Number;
    int Line;

    public:
    // コンストラクタ 
    Token(std::string string, TokenType type, int line)
        : TokenString(string), Type(type), Line(line){
        if(type == TOK_DIGIT){
            Number = atoi(string.c_str());
        } else {
            Number = 0x7fffffff;
        }
    };

    // デストラクタ
    ~Token(){
    };

    // トークンの種別を取得
    TokenType getTokenType() {
        return Type;
    };

    // トークンの文字列表現を取得
    std::string getTokenString(){
        return TokenString;
    };

    // トークンの数値を取得（トークンの種別が数字である場合に使用）
    int getNumberValue(){
        return Number;
    };

    // トークンの出現した行数を取得
    int getLine(){
        return Line;
    };
};

/**
 * 5.5 TokenStream classの宣言
 * 切り出したToken格納用クラス
 */
class TokenStream {
    private:
    std::vector<Token*> Tokens;
    int CurIndex;

    public:
    TokenStream() : CurIndex(0){}
    ~TokenStream();

    bool ungetToken(int Times=1);
    bool getNextToken();
    bool pushToken(Token *token){
        Tokens.push_back(token);
        return true;
    }
    Token getToken();

    // トークンの種類を取得
    TokenType getCurType(){
        return Tokens[CurIndex]->getTokenType();
    }

    // トークンの文字列表現を取得
    std::string getCurString(){
        return Tokens[CurIndex]->getTokenString();
    }

    // トークンの数値を取得
    int getCurNumVal(){
        return Tokens[CurIndex]->getNumberValue();
    }

    // 現在のインデックスを取得
    int getCurIndex(){
        return CurIndex;
    }

    // インデックスを指定した値に設定
    bool applyTokenIndex(int index){
        CurIndex = index;
        return true;
    }
    bool printTokens();
};

TokenStream *LexicalAnalysis(std::string filename);
