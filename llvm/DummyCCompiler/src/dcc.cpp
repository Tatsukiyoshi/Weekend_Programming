#include <llvm/Support/TargetSelect.h>
#include <llvm/Support/Signals.h>
#include <llvm/Support/PrettyStackTrace.h>
#include <llvm/Support/Debug.h>
#include <llvm/Support/raw_os_ostream.h>
#include <string>
#include <APP.hpp>
#include <lexer.hpp>
#include <Parser.hpp>
#include <CodeGen.hpp>

// 5.47 OptionParser
/**
 * オプション切り出し用クラス
 */
class OptionParser {
    private:
        std::string InputFilename;
        std::string OutputFilename;
        int Argc;
        char **Argv;

    public:
        OptionParser(int argc, char **argv) : Argc(argc), Argv(argv){}
        void printHelp(){   // ヘルプ表示
            fprintf(stdout, "Compiler for DummyC...\n 試作中なのでバグがあったらご報告を\n");
        }
        std::string getInputFilename(){
            return InputFilename;
        }
        std::string getOutputFilename(){
            return OutputFilename;
        }
        bool parseOption(); // オプション切り出しメソッド
};

// 5.48 ParseOption
/**
 * オプション切り出し
 * @return 成功時：true 失敗時：false
 */
bool OptionParser::parseOption(){
    if(Argc < 2){
        fprintf(stderr, "引数が足りません\n");
        return false;
    }

    for(int i = 1; i < Argc; i++){
        if(Argv[i][0] == '-' && Argv[i][1] == 'o' && Argv[i][2] == '\0'){
            // output filename
            OutputFilename.assign(Argv[++i]);
        } else if(Argv[i][0] == '-' && Argv[i][1] == 'h' && Argv[i][2] == '\0'){
            printHelp();
            return false;
        } else if(Argv[i][0] == '-'){
            fprintf(stderr, "%sは不明なオプションです\n", Argv[i]);
            return false;
        } else {
            // input filename
            InputFilename.assign(Argv[i]);
        }
    }

    // OutputFilename
    std::string ifn = InputFilename;
    int len = ifn.length();
    if(OutputFilename.empty() && (len > 2) && ifn[len - 3] == '.' &&
    (ifn[len - 2] == 'd' && ifn[len - 1] == 'c')){
        OutputFilename = std::string(ifn.begin(), ifn.end() - 3);
        OutputFilename += ".ll";
    } else if(OutputFilename.empty()){
        OutputFilename = ifn;
        OutputFilename += ".ll";
    }

    return true;
}

// 5.49 初期化
// 5.50 作成した各種クラスによるコンパイル実行
// 5.51 ファイル出力と終了処理
/**
 * main関数
 */
int main(int argc, char **argv){
    llvm::InitializeNativeTarget();
    llvm::sys::PrintStackTraceOnErrorSignal(argv[0]);
    llvm::PrettyStackTraceProgram X(argc, argv);
    llvm::EnableDebugBuffering = true;

    OptionParser opt(argc, argv);
    if(!opt.parseOption())
        exit(1);

    // check
    if(opt.getInputFilename().length() == 0){
        fprintf(stderr, "入力ファイル名が指定されていません\n");
    }

    // lex and parse
    Parser *parser = new Parser(opt.getInputFilename());
    if(!parser->doParse()){
        fprintf(stderr, "err at parser or lexer\n");
        SAFE_DELETE(parser);
        exit(1);
    }

    // get AST
    TranslationUnitAST &tunit = parser->getAST();
    if(tunit.empty()){
        fprintf(stderr, "TranslationUnit is empty");
        SAFE_DELETE(parser);
        exit(1);
    }

    CodeGen *codegen = new CodeGen();
    if(!codegen->doCodeGen(tunit, opt.getInputFilename())){
        fprintf(stderr, "err at codegen\n");
        SAFE_DELETE(parser);
        SAFE_DELETE(codegen);
        exit(1);
    }

    // get Module
    llvm::Module &mod = codegen->getModule();
    if(mod.empty()){
        fprintf(stderr, "Module is empty\n");
        SAFE_DELETE(parser);
        SAFE_DELETE(codegen);
        exit(1);
    }

    PassManager pm;

    // 出力
    std::string error;
    llvm::raw_fd_ostream raw_stream(opt.getOutputFilename().c_str(), error);
    pm.add(createPrintModulePass(&raw_stream));
    pm.run(mod);
    raw_stream.close();

    // delete
    SAFE_DELETE(parser);
    SAFE_DELETE(codegen);

    return 0;
}
