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
