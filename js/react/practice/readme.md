*   モダンJavaScriptの基本から始めるReact実践の教科書

* reactのトラブルシューティング
    * tailwindcss を使った際、開発サーバが起動できない
        *   postcss-flexbugs-fixesおよびpostcss-preset-envがインストールされていないので、インストールしなおす
        ```\
        npm install -D postcss-flexbugs-fixes
        npm install -D postcss-preset-env
        ```
        * postcss 8 が必要
        https://github.com/postcss/postcss/wiki/PostCSS-8-for-end-users
        