*   Windows 11
    1.  Start a New Tauri Project
        ```
        npx create-tauri-app
        ```
    1.  Install Tauri CLI package as a dev dependency
        ```
        npm init
        npm install -D @tauri-apps/cli
        ```
    1.  install Tauri CLI as a cargo subcommand
        ```
        cargo install tauri-cli --locked --version "^1.0.0-rc"
        ```
    1.  Install Tauri API Package as a Dependency (optional)
        ```
        npm install @tauri-apps/api
        ```
    1.  Initialize Tauri in Your App
        ```
        cargo tauri init
        ```
    1.  Check tauri info to Make Sure Everything Is Set up Properly
        ```
        cargo tauri info
        ```

        ```txt
        PS D:\Repository\Weekend_Programming\rust\tauri-app> cargo tauri info

        Environment
        › OS: Windows 10.0.22000 X64
        › Webview2: 102.0.1245.33
        › MSVC: 
        › Node.js: 16.15.1
        › npm: 8.11.0
        › pnpm: Not installed!
        › yarn: Not installed!
        › rustup: 1.24.3
        › rustc: 1.61.0
        › cargo: 1.61.0
        › Rust toolchain: stable-x86_64-pc-windows-msvc 

        Packages
        › @tauri-apps/cli [NPM]: 1.0.0-rc.13
        › @tauri-apps/api [NPM]: 1.0.0-rc.6
        › tauri [RUST]: 1.0.0-rc.14,
        › tauri-build [RUST]: 1.0.0-rc.12,
        › tao [RUST]: 0.9.1,
        › wry [RUST]: 0.17.0,

        App
        › build-type: bundle
        › CSP: unset
        › distDir: ../dist
        › devPath: ../dist

        App directory structure
        ├─ dist
        ├─ node_modules
        └─ src-tauri
        ```
    1.  Start Tauri Development Window
        ```
        cargo tauri dev
        ```
*   Ubuntu 22.04
    1.  npmインストール
        ```
        $ sudo apt-get install npm -y
        ```
    1.  nodeインストール
        ```
        $ sudo npm install n -g
        $ sudo n stable
        $ node -v
        ```
    1.  yarnインストール
        ```
        $ sudo npm install yarn -g
        ```
*   Chrome OS Flex
    1.  npmインストール
        ```
        $ sudo apt install npm -y
        ```
    1.  nodeインストール
        ```
        $ sudo npm install n -g
        $ sudo n stable
        $ node -v
        ```
