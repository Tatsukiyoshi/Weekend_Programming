*   Denoを試してみる
    -   インストール
        *   Windows
            ```
            iwr https://deno.land/install.ps1 -useb | iex
            ```
            ![インストール結果](../images/Deno_install.png)
        *   Chrome OS Flex
            ```
            curl -fsSL https://deno.land/x/install/install.sh | sh
            ```
*   Deno更新
    ```
    deno upgrade
    ```
*   [fresh Get Started](https://fresh.deno.dev/docs/getting-started)
    ```
    deno run -A -r https://fresh.deno.dev my-project
    cd my-project
    deno task start
    ```
