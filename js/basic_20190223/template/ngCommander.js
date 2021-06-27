/*
 * ngxコマンドツール
 *2019/1/1
 *(c)Staffnet Inc.
 *
 *　実習環境は、アプリごとのフォルダー内に全ての関連ソフトウェアを組み込んでいます。
 *  その環境でもngコマンドと同じ操作ができるコマンドとして ngx を提供しています。
 * 
 * 1)ngコマンド互換
 * ngをngxに置き換えることでAngular CLIをグローバルインストールした環境と同じ操作ができます
 * 
 *２）pwa用コマンド追加
 * PWA用のビルドを簡単かつ高速にするためのコマンド追加
 * ngx pwaBuild　実運用ビルド（最適化あり、ソースマップなし）
 * ngx pwaDebug　開発用ビルド（最適化あり、ソースマップあり）
 * ngx pwaAuto  開発用ビルド（最適化あり、ソースマップあり、コード監視ビルド）
 *
 * ４)Webサーバ起動コマンド追加
 * ngx web ドキュメントルート　コマンドオプション
 *
 * 起動と同時にブラウザを開く
 * 空きポートを探して起動
 *
 * [処理の仕組み]
 * Angra cli のngコマンドをトラップするバッチファイルと
 * Windows のコマンドを発行するJavaScriptファイルのセットになっています
 *
 * 1.ngx.batが、コマンドプロンプトからの呼び出しを受ける　
 * 2.ngCommander.jsが、コマンドの解析と拡張機能
 *
 * カスタマイズ
 * ngCommander.js先頭部分のCommandオブジェクトの定数変更可能
 */

//即時関数開始
(async () => {

//Windows コマンド実行のパッケージ読み込み
  const {spawn} = require("child_process");

  //--------メイン開始-----------
  //ツール全体で共有するコマンドオブジェクト
  let Command = {
    subCmd: "",
    target: "",
    ngcommand: ".\\node_modules\\.bin\\ng.cmd",
    buildOutputPath: ".\\dist",
    portNumber: 3200,
    cliVersion: "7.1",
    projectDir: "",
    runCmdOption: {},
    inputCmdOption: {},
    presetCmdOption: {
      base:
        {
          outputPath: ".\\dist",
          deleteOutputPath: true
        },
      production:
        {
          prod: true,
          sourceMap: false
        },
      development:
        {
          prod: true,
          aot: false,
          buildOptimizer: false,
          optimization: false,
          outputHashing: "none",
          sourceMap: "true"
        },
      pwa:
        {
          serviceWorker: true
        }

    }
  };
  //コマンドオブジェクトの初期化
  Command.presetCmdOption.base.outputPath = Command.buildOutputPath;
  Command.projectDir = process.cwd();//カレントディレクトリの取得

  console.log("Current Work Dir:" + Command.projectDir);

  //コマンド入力からパラメーターの取得
  //subCommand, target, commandOptions
  let ret = getParam();

  //コマンドオブジェクトの生成
  Command.inputCmdOption = getCommandOptionObj(ret.subCmd, ret.options);
  Command.subCmd = ret.subCmd;
  Command.target = ret.target;

  //取得したコマンドオブジェクトの確認表示
  console.log();
  console.log("入力コマンド: ng " + Command.subCmd + " " + Command.target
    + " " + getCommandOptionStr(Command.inputCmdOption));

  //コマンドの変換と実行
  await convertSubCommand(Command);

  //--------メイン終了-----------

  //コマンド入力のパラメータ
  // arg0:node arg1:ng arg2:subCommand arg3:target or option
  // arg4～:option
  function getParam() {
    let argLen = process.argv.length;
    for (let i = 0; i < argLen; i++) {
      console.log("引数%d=%s", i + 1, process.argv[i]);
    }
    let subCmd = process.argv[2];
    let options = [];
    let target = "";

    //arg3の判定(-から始まっていれば、コマンドオプション)
    if (argLen > 3) {
      if (process.argv[3].slice(0, 1) !== "-") {
        target = process.argv[3];
        if (argLen > 4) {
          options = process.argv.slice(4);
        }
      } else {
        options = process.argv.slice(3);
      }
    }

    //短縮1文字表記を標準コマンドに変換
    let shortSubCmd = {
      "b": "build",
      "d": "doc",
      "e": "e2e",
      "g": "generate",
      "l": "lint",
      "n": "new",
      "s": "serve",
      "t": "test",
      "v": "version",
    };

    if (subCmd.length === 1) {
      subCmd = shortSubCmd[subCmd];
    }
    return {subCmd, target, options};
  }

  function getCommandOptionObj(subCmd, cmdOptArr) {

    let shortCmdOpt = {
      "-c": "configuration",
      "-d": "dry-run",
      "-f": "force",
      "-g": "global",
      "-o": "open",
      "-p": "prefix",
      "-S": "skip-tests",
      "-s": "search",
      "-t": "inline-template",
      "-v": "verbose",
    };
//"-c":"--collection",が重複(newサブコマンドで使われる）

//入力された引数からコマンドオプションオブジェクトを作成
    let cmdOptObj = {};
    cmdOptArr.length && cmdOptArr.forEach(opt => {
      let tmpArr = opt.split("=");
      let key = tmpArr[0];
	  
      //keyのみ指定の時はValueにTRUEを代入
      let value = tmpArr.length === 1 ? true : tmpArr[1];
      
	  //1文字表記のオプションを標準記に変換
      if (key.length === 2) {
        if (!shortCmdOpt[key]) {
          console.log("オプション指定が無効です[" + key + "]");
          process.exit(1);
        }
        if (subCmd === "new" && key === "-c") {
          cmdOptObj["collection"] = value;
        } else {
			
          let longCmdOpt = shortCmdOpt[key];
          cmdOptObj[longCmdOpt] = value;
        }
      } else {
        cmdOptObj[key.slice(2)] = value;
      }
    });

    return cmdOptObj;
  }

  function getCommandOptionStr(cmdOptObj) {
    let optStr = "";
    Object.keys(cmdOptObj).forEach(key => {
      optStr += " --" + key + "=" + cmdOptObj[key];
    });
    return optStr;
  }

  //サブコマンドの変換
  async function convertSubCommand(commandObj) {


    switch (commandObj.subCmd) {
      case "build":
        commandObj.runCmdOption = Object.assign(
          commandObj.presetCmdOption.base,
          commandObj.presetCmdOption.development,
          commandObj.inputCmdOption
        );
        await runNgCommand(commandObj);
        break;

      case "serve":
        commandObj.runCmdOption = Object.assign(
          commandObj.presetCmdOption.base,
          commandObj.inputCmdOption
        );
        await runNgCommand(commandObj);
        break;

      case "pwaBuild":
        /*
		commandObj.inputCmdOption = Object.assign(
          commandObj.presetCmdOption.base,
          commandObj.presetCmdOption.production,
          commandObj.presetCmdOption.pwa,
          commandObj.inputCmdOption
        );
        commandObj.subCmd = "build";
        await runNgCommand(commandObj);
		*/
        await runWinCommand("npx ng build --prod --output-path=dist --delete-output-path=true");
		//await runWinCommand("npm cache verify");
        break;

      case "pwaDebug":
        commandObj.runCmdOption = Object.assign(
          commandObj.presetCmdOption.base,
          commandObj.presetCmdOption.development,
          commandObj.presetCmdOption.pwa,
          commandObj.inputCmdOption
        );
        commandObj.subCmd = "build";
        await runNgCommand(commandObj);
        break;

      case "pwaAuto":
        commandObj.runCmdOption = Object.assign(
          commandObj.presetCmdOption.base,
          commandObj.presetCmdOption.development,
          commandObj.presetCmdOption.pwa,
          {sourceMap: true},
          commandObj.inputCmdOption
        );
        commandObj.subCmd = "build";
        await runNgCommand(commandObj);

        commandObj.runCmdOption = Object.assign(
          commandObj.presetCmdOption.base,
          commandObj.presetCmdOption.development,
          commandObj.presetCmdOption.pwa,
          {sourceMap: true},
          {deleteOutputPath: false},
          {watch: true},
          commandObj.inputCmdOption
        );
        commandObj.subCmd = "build";
        await runNgCommand(commandObj);
        break;

      case "new":
        await makeTemplate(commandObj);
        break;

   case "pwaNew":
        await runWinCommand("npm cache verify");
        await runWinCommand("npx ng new "+commandObj.target +" --defaults=true --skip-git");
		await runWinCommand("copy ngx.bat .\\"+commandObj.target+"\\ngx.bat");
		await runWinCommand("copy ngCommander.js .\\"+commandObj.target+"\\ngCommander.js");
		//await runWinCommand("npm cache verify");
		break;
	
case "pwaAdd":
		await runWinCommand("npm cache verify");
		await runWinCommand("npx ng add @angular/pwa@0.12  --defaults=true");
		break;

	
   case "pwaAddFull":
		await runWinCommand("npm cache verify");
		await runWinCommand("npm install @angular/cdk@7.1");
		await runWinCommand("npx ng add @angular/material@7.1 --defaults=true");
		await runWinCommand("npx ng add @angular/pwa@0.12  --defaults=true");
		break;

   case "web":
        await webStart(commandObj);
        break;

      default:
        await runNgCommand(commandObj);
    }
  }

  //node.jsでWindowsコマンド実行
  async function runNgCommand(commandObj, config) {

    let cmdStr = commandObj.ngcommand + " " + commandObj.subCmd
      + commandObj.target
      + getCommandOptionStr(
        commandObj.runCmdOption || commandObj.inputCmdOption);

    //windowsコマンドの実行（promiseを返す）
    return await runWinCommand(cmdStr, config);

  }

  //windowsコマンドの実行（promiseを返す）
  function runWinCommand(commandStr, config) {

    return new Promise((resolve, reject) => {

      //console.timeEndとペアで時間計測
      console.time("OK 処理時間");

      //実行するコマンドの確認表示
      console.log("\n実行コマンド:" + commandStr);

	  //コマンド実行時のspawn動作モード設定
    let defaultOpt = {
      shell: true, //入力された小文字をコマンドプロンプトでそのまま実行
      cwd: process.cwd(),//カレントディレクトリを一時ディレクトリとして利用
      stdio: "inherit", //実行中のコンソール出力を受け付ける
    };
      let conf = Object.assign(defaultOpt, config);

      //コマンドの実行
      let cp = spawn(commandStr, conf);

      //エラー発生
      cp.on("error", (error) => {
        reject(error);
        process.exit(1);
      });

      //終了処理
      cp.on("close", (code) => {
        if (code === 0) {
          console.timeEnd("OK 処理時間");
          console.log();
          resolve("success");
        } else {
          console.log("終了コード:" + code);
          reject(code);
        }
      });
    }).catch(error => {
      console.error("コマンド実行エラー\n %o", error);
      process.exit(1);
    });

  }

  //新規プロジェクト作成
  async function makeTemplate(commandObj) {

    //デフォルトのコマンドオプション値
    let defaultOpt = {
      defaults: true,
      directory:".\\"
    };
    //コマンドオプションのデフォルト値と入力値をマージ
    let opts = Object.assign(defaultOpt, commandObj.inputCmdOption);

    let projectName = commandObj.target;
    let initDir = process.cwd();
    let newProjDir = initDir + "\\" + projectName;
    console.log(newProjDir);

    //新規プロジェクトフォルダを作成
    let cmdStr = "md " + newProjDir;
    await runWinCommand(cmdStr);
	//await runWinCommand(cmdStr, {cwd: initDir});
	
	//カレントディレクトリを新規プロジェクトフォルダへ変更
	process.chdir(newProjDir);
	
    //新規プロジェクトにngxツールをコピー
    cmdStr = "mklink/h ngCommander.js ..\\..\\install\\ngx\\ngCommander.js"
      + "&& mklink/h ngx.bat ..\\..\\install\\ngx\\ngx.bat";
    await runWinCommand(cmdStr);
	//await runWinCommand(cmdStr, {cwd: newProjDir});
    
	//キャッシュベリファイ
    cmdStr = "npm cache verify";
    await runWinCommand(cmdStr, {cwd: newProjDir});
    
	//Angular CLIをバージョンを指定してインストール
    cmdStr = "npm install @angular/cli@"
      + commandObj.cliVersion + " --save-dev";
	await runWinCommand(cmdStr, {cwd: newProjDir});
	
	cmdStr = "npm cache verify"
	await runWinCommand(cmdStr, {cwd: newProjDir});
	
    //ng newコマンドの呼び出し
    cmdStr = newProjDir + "\\node_modules\\.bin\\ng.cmd new "
      + projectName + " --directory="+opts.directory+" --defaults="+opts.defaults.toString();
	await runWinCommand(cmdStr, {cwd: newProjDir});

	//プロジェクト内の脆弱性、不備をチェック
	cmdStr = "npm audit fix"
	return await runWinCommand(cmdStr, {cwd: newProjDir});

	}


  //uildの機能を追加
  async function addPwaFunction(commandObj) {
    //デフォルトのコマンドオプション値
    let defaultOpt = {
      defaults: true
    };
    //コマンドオプションのデフォルト値と入力値をマージ
    let opts = Object.assign(defaultOpt, commandObj.inputCmdOption);

	cmdStr = "npm cache verify"
	await runWinCommand(cmdStr);
	
	cmdStr = "npm cache verify"
	await runWinCommand(cmdStr);
	
	//cdk
    cmdStr =  "npm i @angular/cdk@7.1"
	await runWinCommand(cmdStr);
	
    //ng addコマンドの呼び出し
    cmdStr =  ".\\node_modules\\.bin\\ng.cmd add "
      + " @angular/material  --defaults="+opts.defaults.toString();
	await runWinCommand(cmdStr, {cwd: newProjDir});

    //ng addコマンドの呼び出し
    cmdStr =  ".\\node_modules\\.bin\\ng.cmd add "
      + " @angular/pwa --defaults="+opts.defaults.toString();
	await runWinCommand(cmdStr, {cwd: newProjDir});

	//プロジェクト内の脆弱性、不備をチェック
	cmdStr = "npm audit fix"
	return await runWinCommand(cmdStr, {cwd: newProjDir});

	} 



  //Webサーバー起動
  async function webStart(commandObj) {

    //デフォルトのコマンドオプション値
    let defaultOpt = {
      open: true,
      port: null,
      ssl: true,
      cert: ".\\cert.pem",
      key: ".\\key.pem",
    };

    //コマンドオプションのデフォルト値と入力値をマージ
    let opts = Object.assign(defaultOpt, commandObj.inputCmdOption);

    //http サーバー起動コマンド
    let cmdStr = "start http-server "
	
      //ターゲットの指定がない場合はデフォルト値をドキュメントルートに設定
      + (commandObj.target || commandObj.buildOutputPath)
      
	  //キャッシュを無効
      + " -c-1"
      
	  //ポート番号の指定が入力された時は設定を行う
      + (opts.port ? (" -p" + opts.port) : "")

      //サーバー起動時にブラウザを開く（デフォルト値は開く）    
	  + (opts.open ? " -o" : "");
    //分離したプロセスとして実行
    return await runWinCommand(cmdStr
      , {detached: true, stdio: "ignore"}
    );
  }

})();
