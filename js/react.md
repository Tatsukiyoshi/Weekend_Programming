* react スタートアップ
    - node.jsインストール
        - 古いバージョンをアンインストールするなら、下記ディレクトリのライブラリ(node-modules)は整理した後で！（グローバルにインストールしていなければ、問題なし）
            1.  ユーザディレクトリのAppData\Roaming\npm
            1.  ユーザディレクトリのAppData\Roaming\npm-cache 

* reactのトラブルシューティング
    - npx create-react-app "package-name"(npm install)でmissing dependenciesエラー <BR>
        - 実行時に見つからないパッケージが表示されたら、そのパッケージをインストールする
        ```
        npm install --save "@xxx"
        ```
    - npm startでエラー
        - 以下のコマンドで解決するらしい
        ```
        npm config set scripts-prepend-node-path true
        ```
