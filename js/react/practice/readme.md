*   モダンJavaScriptの基本から始めるReact実践の教科書
    *   プロジェクト作成
        *   JavaScript
            ```
            npx create-react-app <プロジェクト名>
            ```
        *   TypeScript
            ```
            npx create-react-app <プロジェクト名> --template typescript
            ```
    *   reactのトラブルシューティング
        *   'React' must be in scope when using JSX
            *   先頭に下記一行を追加する
                ```js
                import { React } from "react";
               ```
        *   tailwindcss を使った際、開発サーバが起動できない
            *   postcss-flexbugs-fixesおよびpostcss-preset-envがインストールされていないので、インストールしなおす
            ```\
            npm install -D postcss-flexbugs-fixes
            npm install -D postcss-preset-env
            ```
            *   postcss 8 が必要
            https://github.com/postcss/postcss/wiki/PostCSS-8-for-end-users
        