// g++ -g ./src/lexer.cpp -I./inc `llvm-config --cxxflags --ldflags --libs` -c -o ./obj/lexer.o
#include <APP.hpp>
#include <lexer.hpp>
/**
  * 5.6 TokenStream classの定義
  */
/**
  * デストラクタ
  */
TokenStream::~TokenStream(){
    for(int i = 0; i < Tokens.size(); i++){
      SAFE_DELETE(Tokens[i]);
    }
    Tokens.clear();
}

/**
 * トークン取得
 * @return CurIndex番目のToken
 */
Token TokenStream::getToken(){
  return *Tokens[CurIndex];
}

/**
 * インデックスを1つ増やして次のトークンに進める
 * @return 成功時：true　失敗時：false
 */
bool TokenStream::getNextToken(){
  int size = Tokens.size();

  if(--size <= CurIndex){
    return false;
  } else {
    CurIndex++;
    return true;
  }
}

/**
 * インデックスをtimes回戻す
 */
bool TokenStream::ungetToken(int times){
  for(int i = 0; i < times; i++){
    if(CurIndex == 0){
      return false;
    } else {
      CurIndex--;
    }
  }
  return true;
}

/**
 * 格納されたトークン一覧を表示する
 */
bool TokenStream::printTokens(){
  std::vector<Token*>::iterator titer = Tokens.begin();

  while(titer != Tokens.end()){
    fprintf(stdout,"%d:", (*titer)->getTokenType());
    if((*titer)->getTokenType() != TOK_EOF)
      fprintf(stdout, "%s\n", (*titer)->getTokenString().c_str());
    ++titer;
  }
  return true;
}

/**
 * 5.7 lexer
 * トークン切り出し関数
 * @param 字句解析対象ファイル名
 * @return 切り出したトークンを格納したTokenStream
 */
TokenStream *LexicalAnalysis(std::string input_filename){
  TokenStream *tokens = new TokenStream();
  std::ifstream ifs;
  std::string cur_line;
  std::string token_str;
  int line_num = 0;
  bool iscomment = false;

  // 字句解析対象ファイルを入力オープンする
  ifs.open(input_filename.c_str(), std::ios::in);
  if(!ifs)  // オープン失敗した場合には、NULLを返す
    return NULL;

  // 字句解析対象ファイルを最後まで読み込む
  while(ifs && getline(ifs, cur_line)){
    char next_char;
    std::string line;
    Token *next_token;
    int index = 0;
    int length = cur_line.length();

    // 読み込んだ行を順に解析する
    while(index < length){
      next_char = cur_line.at(index++);

      // コメントを読み飛ばす
      if(iscomment){
        if((length - index) < 2
          || (cur_line.at(index) != '*')
          || (cur_line.at(index++) != '/')) {
            continue;
        } else {
          iscomment = false;
        }
      }

      // EOF
      if(next_char == EOF){
        token_str = EOF;
        next_token = new Token(token_str, TOK_EOF, line_num);
      } else if(isspace(next_char)){  // 空白は読み飛ばす
        continue;
      } else if(isalpha(next_char)){  // 識別子(IDENTIFIER)
        token_str += next_char;
        next_char = cur_line.at(index++);
        while(isalnum(next_char)){    // 後続の文字が英数字である間繰り返す
          token_str += next_char;
          next_char = cur_line.at(index++);
          if(index == length)
            break;
        }
        index--;

        if(token_str == "int"){           // intキーワードの場合
          next_token = new Token(token_str, TOK_INT, line_num);
        } else if(token_str == "return"){ // returnキーワードの場合
          next_token = new Token(token_str, TOK_RETURN, line_num);
        } else {                          // その他識別子の場合
          next_token = new Token(token_str, TOK_IDENTIFIER, line_num);
        }
      // 数字
      } else if (isdigit(next_char)){
        if (next_char == '0'){
          token_str += next_char;
          next_token = new Token(token_str, TOK_DIGIT, line_num);
        } else {
          token_str += next_char;
          next_char = cur_line.at(index++);
          while(isdigit(next_char)){
            token_str += next_char;
            next_char = cur_line.at(index++);
          }
          next_token = new Token(token_str, TOK_DIGIT, line_num);
          index--;
        }
      // コメントまたは除算演算子
      } else if (next_char == '/'){
        token_str += next_char;
        next_char = cur_line.at(index++);

        // コメントの場合
        if (next_char == '/'){        // 単一行コメント
          break;
        } else if (next_char == '*'){ // 複数行コメント行開始
          iscomment = true; // コメントブロック内を示す
          continue;
        } else {                      // 除算演算子
          index--;
          next_token = new Token(token_str, TOK_SYMBOL, line_num);
        }
      // それ以外（記号）
      } else {
        if (next_char == '*' ||
            next_char == '+' ||
            next_char == '-' ||
            next_char == '=' ||
            next_char == ';' ||
            next_char == ',' ||
            next_char == '(' ||
            next_char == ')' ||
            next_char == '{' ||
            next_char == '}'){
          token_str += next_char;
          next_token = new Token(token_str, TOK_SYMBOL, line_num);
        // 解析不能字句が出現した場合、エラーとする（解析結果はNULL）
        } else {
          fprintf(stderr, "unclear token : %c", next_char);
          SAFE_DELETE(tokens);
          return NULL;
        }
      }

      // Tokensに追加し、次の字句処理へ
      tokens->pushToken(next_token);
      token_str.clear();
    }
    token_str.clear();
    line_num++; // 次の行の読み込みへ
  }
  // EOFの確認
  if (ifs.eof()){
    tokens->pushToken(
      new Token(token_str, TOK_EOF, line_num)
      );
  }
  // ファイルクローズ
  ifs.close();
  return tokens;  // 解析結果を返却する
}
