# depandapotによる依存関係更新後のビルド確認

## パッケージ再インストール
 - そもそも、Windows 10の再セットアップ後、@angularをセットアップしていなかったので、再セットアップ
 ---
 npm install -g @angular/xxx
 ---

## ビルド実行
---
> ng build
You seem to not be depending on "@angular/core" and/or "rxjs". This is an error.
---
## ビルドエラーに対する対策
https://stackoverflow.com/questions/49537782/you-seem-to-not-be-depending-on-angular-core
---
> npm update @angular/core
---
> npm install -g webpack-dev-server
---
> npm install -g webpack
---
## キャッシュのクリア
>npm cache clean
npm ERR! As of npm@5, the npm cache self-heals from corruption issues and data extracted from the cache is guaranteed to be valid. If you want to make sure everything is consistent, use 'npm cache verify' instead. On the other hand, if you're debugging an issue with the installer, you can use `npm install --cache /tmp/empty-cache` to use a temporary cache instead of nuking the actual one.
npm ERR!
npm ERR! If you're sure you want to delete the entire cache, rerun this command with --force.

npm ERR! A complete log of this run can be found in:
npm ERR!     C:\Users\taish\AppData\Roaming\npm-cache\_logs\2019-06-23T06_53_10_230Z-debug.log

>npm cache clean --force
npm WARN using --force I sure hope you know what you are doing.
[..................] / : WARN using --force I sure hope you know what you are doing.                                    
## ビルド後の確認
### http-serverのインストール
---
> npm install -g http-server
---
### http-serverの起動

> http-server .\dist\vs-angular -p3000 -c-1 -o
