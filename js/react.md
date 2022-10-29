* react スタートアップ
    - node.jsインストール
        - 古いバージョンをアンインストールするなら、下記ディレクトリのライブラリ(node-modules)は整理した後で！（グローバルにインストールしていなければ、問題なし）
            1.  ユーザディレクトリのAppData\Roaming\npm
            1.  ユーザディレクトリのAppData\Roaming\npm-cache 

* reactのトラブルシューティング
    -   node.js 17以降で実行時エラーとなる（OpenSSL関連）
        -   スクリプト実行時にnodeのopenssl-legacy-providerオプションを有効化するよう、package.jsonを書き換える
            [参考](https://howtojs.io/how-to-solve-digital-envelope-routines-unsupported-or-err_ossl_evp_unsupported-error-when-running-angular-application/)
    -   npx create-react-app "package-name"(npm install)でmissing dependenciesエラー <BR>
        - 実行時に見つからないパッケージが表示されたら、そのパッケージをインストールする
        ```
        npm install --save "@xxx"
        ```
    -   npm startでエラー
        - 以下のコマンドで解決するらしい
        ```
        npm config set scripts-prepend-node-path true
        ```
    -   \\