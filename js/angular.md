1.  コマンド
    *   ng &lt;command&gt;
        - Commands:
            |Command | |
            |-|-|
            |ng analytics                  |Configures the gathering of Angular CLI usage metrics. &lt;BR&gt;See https://angular.io/cli/usage-analytics-gathering|
            |ng completion                 |Set up Angular CLI autocompletion for your terminal.
            |ng config [json-path] [value] |Retrieves or sets Angular configuration values in the angular.json file for the workspace.
            |ng doc &lt;keyword&gt;              |Opens the official Angular documentation (angular.io) in a browser, and searches for a given keyword.  [aliases: d]
            |ng new [name]                 |Creates a new Angular workspace.  [aliases: n]
            |ng version                    |Outputs Angular CLI version.  [aliases: v]

        - Options:
            | | |
            |-|-|
            |--help  |Shows a help message for this command in the console.  [boolean]

        The above commands are available when running the Angular CLI outside a workspace.More commands are available when running inside a workspace.
        For more information, see https://angular.io/cli/.

1.  Quick Start
    ```
    git clone https://github.com/angular/quickstart.git
    ```
    1.  パッケージインストールでのエラー 
        ```
        >npm insatall
        npm WARN EBADENGINE Unsupported engine {
        npm WARN EBADENGINE   package: 'karma@1.7.1',
        npm WARN EBADENGINE   required: { node: '0.10 || 0.12 || 4 || 5 || 6 || 7 || 8' },
        npm WARN EBADENGINE   current: { node: 'v16.15.0', npm: '8.5.5' }
        npm WARN EBADENGINE }
        npm WARN EBADENGINE Unsupported engine {
        npm WARN EBADENGINE   package: 'karma-cli@1.0.1',
        npm WARN EBADENGINE   required: { node: '0.10 || 0.12 || 4 || 5 || 6' },
        npm WARN EBADENGINE   current: { node: 'v16.15.0', npm: '8.5.5' }
        npm WARN EBADENGINE }
        npm WARN deprecated source-map-url@0.4.1: See https://github.com/lydell/source-map-url#deprecated
        npm WARN deprecated urix@0.1.0: Please see https://github.com/lydell/urix#deprecated
        npm WARN deprecated har-validator@5.1.5: this library is no longer supported
        npm WARN deprecated json3@3.3.2: Please use the native JSON object instead of JSON 3
        npm WARN deprecated chokidar@1.7.0: Chokidar 2 will break on node v14+. Upgrade to chokidar 3 with 15x less dependencies.
        npm WARN deprecated source-map-resolve@0.5.3: See https://github.com/lydell/source-map-resolve#deprecated
        npm WARN deprecated resolve-url@0.2.1: https://github.com/lydell/resolve-url#deprecated
        npm WARN deprecated minimatch@0.3.0: Please update to minimatch 3.0.2 or higher to avoid a RegExp DoS issue
        npm WARN deprecated uuid@3.4.0: Please upgrade  to version 7 or higher.  Older versions may use Math.random() in certain circumstances, which is known to be problematic.  See https://v8.dev/blog/math-random for details.
        npm WARN deprecated request@2.88.2: request has been deprecated, see https://github.com/request/request/issues/3142    
        npm WARN deprecated @angular/http@4.3.6: Package no longer supported. Use @angular/common instead, see https://angular.io/guide/deprecations#angularhttp
        npm WARN deprecated core-js@2.6.12: core-js@<3.4 is no longer maintained and not recommended for usage due to the number of issues. Because of the V8 engine whims, feature detection in old core-js versions could cause a slowdown up to 100x even if nothing is polyfilled. Please, upgrade your dependencies to the actual version of core-js.
        ```
    1.  ビルドエラー
        ```
        PS D:\Repository\Tatsukiyoshi\Weekend_Programming\js\angular\quickstart> npm run build

        > agular-quickstart@1.0.0 build
        > tsc -p src/

        node_modules/@types/component-emitter/index.d.ts(8,25): error TS1005: ',' expected.
        node_modules/@types/cors/index.d.ts(41,52): error TS1005: ',' expected.
        node_modules/@types/cors/index.d.ts(47,44): error TS1005: ',' expected.
        node_modules/@types/cors/index.d.ts(47,47): error TS1005: ',' expected.
        node_modules/@types/node/index.d.ts(20,1): error TS1084: Invalid 'reference' directive syntax.
        ```

1.  gitでの資産管理
    1.  .gitignore
        .angular/cache 配下が除外されていないので、修正する。
        ```
        /.angular/cache
        ```
        ↓
        ```
        .angular/cache
        ```

1.  ビルドエラーに対する対策
    1.  バリデーションチェックの記述
        *   プロパティアクセスの記述が変更になり、古い記述だとエラーになる。
            ```
            error TS4111: Property 'minlength' comes from an index signature, so it must be accessed with ['minlength'].
            ```
            *   旧型式
                ```
                    <span *ngIf="mail.errors?.required">メールアドレスは必須です。</span>
                ```
            *   新形式
                ```
                    <span *ngIf="mail.errors?.['required']">メールアドレスは必須です。</span>
                ```

1.  depandapotによる依存関係更新後のビルド確認

    1.  パッケージ再インストール <BR />

        そもそも、Windows 10の再セットアップ後、@angularをセットアップしていなかったので、再セットアップ
            ```
            npm install -g @angular/xxx
            ```

    1.  ビルド実行
        ```
        > ng build
        You seem to not be depending on "@angular/core" and/or "rxjs". This is an error.
        ```

    1.  ビルドエラーに対する対策
        https://stackoverflow.com/questions/49537782/you-seem-to-not-be-depending-on-angular-core
        ```
        > npm update @angular/core
        ```
        > npm install -g webpack-dev-server
        ```
        > npm install -g webpack
        ```
    1.  キャッシュのクリア
        ```
        >npm cache clean
        npm ERR! As of npm@5, the npm cache self-heals from corruption issues and data extracted from the cache is guaranteed to be valid. If you want to make sure everything is consistent, use 'npm cache verify' instead. On the other hand, if you're debugging an issue with the installer, you can use `npm install --cache /tmp/empty-cache` to use a temporary cache instead of nuking the actual one.
        npm ERR!
        npm ERR! If you're sure you want to delete the entire cache, rerun this command with --force.
        npm ERR! A complete log of this run can be found in:
        npm ERR!     C:\Users\taish\AppData\Roaming\npm-cache\_logs\2019-06-23T06_53_10_230Z-debug.log

        >npm\ cache clean --force
        npm WARN using --force I sure hope you know what you are doing.
        [..................] / : WARN using --force I sure hope you know what you are doing.                                    
        ```

    1.  ビルド後の確認
        1.  http-serverのインストール
            ```
            > npm install -g http-server
            ```
        1.  http-serverの起動
            ```
            > http-server .\dist\vs-angular -p3000 -c-1 -o
            ```
1.  in-memory-web-api
    -   [Angular in-memory-web-api を使う](https://watermargin.net/programming/angular/in-memory-web-api/)

1.  rxjs
    -   [【Rxjs基礎講座】RxJSのMap系メソッドをコーディングしながら具体的にどう違うか考えてみる](https://deep.tacoskingdom.com/blog/53)
