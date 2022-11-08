*   Vercelホスティングサービス
    *   プロジェクト（ローカルリポジトリ）の作成
        ```
        npx create-next-app nextjs-blog --use-npm --example "https://github.com/vercel/next-learn/tree/master/basics/learn-starter"
        ```
    *   Githubリポジトリ作成
    *   Githubへプッシュする
        ```
        git remote add origin https://github.com/Tatsukiyoshi/nextjs-blog.git
        git push -u origin main
        ```
    *   DPS Workflow
        Pull Requestを発行すると、VercelでPreviewすることができ、Mergeすると、正式サイト（Production）に昇格する。<BR>
        Develop -> Preview -> Ship
*   Next.js 13新機能
    *   Appフォルダ
        ```
        npx create-next-app nextjs13-sample --ts --experimental-app --use-npm
        ```
        [（参考）Next.js 13 で開発方法はどう変わる？](https://zenn.dev/jtakahashi64/articles/a9d2ae3285ceb6)

        *   Error対策
            -   https://nextjs.org/docs/messages/link-no-children
            -   https://nextjs.org/docs/messages/react-hydration-error
    *   TurboPack
        ```
        npx create-next-app --ts --example with-turbopack
        ```
        [Next.js 13の新機能のTurbopackを試してみる](https://zenn.dev/saltedlemon/articles/fa4104d5041a26)
        ↓
        これであれば、Appフォルダも使えるようになっていた。
