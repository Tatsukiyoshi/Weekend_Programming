@echo on

rem サーバー起動
cd %~dp0timerServer
start node index.js

rem サーバーの起動を10秒間待機
timeout /T 10

rem ブラウザを開く
start https://localhost/public/init.html
rem start https://localhost/list

exit