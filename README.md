# 独学プログラミング演習
##  共通
### OS
  - [Windows Insider Dev Channel Build 23620](https://aka.ms/DevLatest)
    <span style="color: red;">*<<2024/01/26 updated from 23619>>*</span>
    ![デスクトップ](./images/Windows/20240126_Windows11_Build23620.png)
    - [履歴](./windows/history.md)
  - [WSL2](https://learn.microsoft.com/ja-jp/windows/wsl/install)
    - WSLバージョンを確認する
      ```
      wsl --version
      ```
    - WSLを更新する
      ```
      wsl --update
      ``` 
    - [Ubuntu 22.04.3](https://www.releases.ubuntu.com/jammy/)
      ![22.04.3 LTS](./images/Windows/20230826_WSL_Ubuntu22.04.3.png)
      - [履歴](./wsl/history.md)
      - ディストリビューションのバージョンを確認する
        ```
        lsb_release -a
        ```
  - [Chrome OS Flex 120.0.6099.235](https://chromereleases.googleblog.com/search/label/ChromeOS%20Flex) <span style="color: red;">*<<2024/01/19 updated from 120.0.6099.203>>*</span>
    ![Chrome OS Flexバージョン情報](./images/Chrome/20240119_Chrome_OS_Flex_120.0.6099.235.png)
    - [履歴](./chrome/history.md)
  - [Oracle Cloud](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/OracleCloud)
### ツール
  - [Visual Studio Code 1.85.2](https://code.visualstudio.com/) <span style="color: red;">*<<2024/01/19 updated from 1.85.1>>*</span> <BR />
    開発環境はVisual Studio Codeを中心に使っており、インストールしている拡張機能の一覧は、[VSCode拡張機能](_sub/vscodeExtensions.md)にまとめてあります。<BR />
    - Chrome OS Flexではコマンドでアップデート
    ![Upgrade on Chrome OS Flex](./images/Chrome/20240119_code_1.85.2.png)
    - 1.82で発生していたデバッグコンソールがクリアできなくなった問題は、1.82.2で解消
  - [Git 2.43](https://git-scm.com/download) <span style="color: red;">*<<2023/11/30 updated from 2.42>>*</span>
    - Windowsでの更新
      ```
      git update-git-for-windows
      ```
  - [GitHub Desktop 3.3.8](https://desktop.github.com/release-notes/) <span style="color: red;">*<<2024/01/20 updated from 3.3.6>>*</span>
    - サイトでのリリース通知があってから、アップデートできるまでにはタイムラグがありそう

##  言語別ページ
### [Database & SQL](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Database)
### [Documentation](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Documentation)
### [Docker](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Docker)
### [.NET](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/.NET)
### [Rust](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Rust)
### [Kotlin](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Kotlin)
### [Java](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Java)
### [Dart/flutter](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Flutter)
### [TypeScript/JavaScript](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/TypeScript)
### [PHP](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Php)
### [Go](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Go)
### [Python](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Python)
### [Pascal](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Others#pascal)
### [Swift](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Others#swift)
### [Carbon](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Carbon)
### [LLVM](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Others#llvm)
### [Unity](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Unity)
### [Exercism](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Exercism)

##  ノウハウ
### Windows
  - [USBメモリの復旧](https://jp.easeus.com/partition-manager/fix-usb-drive-incorrect-size.html)
  - [Dev Channelへの変更](https://mitomoha.hatenablog.com/entry/2023/08/11/010623)
  - システムロケールの変更 <BR>
    VSCodeでターミナル等の出力が化ける場合、システムロケールとしてUTF-8を使用する設定を有効にする
    1.  設定アプリで言語と地域を開き、管理用の言語の設定をクリック
        ![言語と地域](./images/Windows/20230921_SystemLocale1.png)
    1.  地域ダイアログの「システムロケールの変更」をクリック
        ![地域](./images/Windows/20230921_SystemLocale2.png)
    1.  地域の設定ダイアログの「ベータ：ワールドワイド言語サポートでUnicode UTF-8を使用」にチェック
        ![地域の設定](./images/Windows/20230921_SystemLocale3.png)
    1.  再起動するまで変更が有効にならないので、再起動する
  - PowerShell
    - 環境変数の確認
      ```shell
      $env:Path.Split(";")
      ```
    - [文字エンコードについて](https://learn.microsoft.com/ja-jp/powershell/module/microsoft.powershell.core/about/about_character_encoding?view=powershell-7.3)
      - PowerShell上でUTF-8(BOMなし)に変更する
        ```shell
        $PSDefaultParameterValues['Out-File:Encoding'] = 'utf8'
        ```
      - VSCodeでPowerShellを開くときに変更するよう設定する
        ```json
            "terminal.integrated.profiles.windows": {
                "PowerShell": {
                    "source": "PowerShell",
                    "icon": "terminal-powershell",
                    "args": [
                        "-Command",
                        "$PSDefaultParameterValues['Out-File:Encoding'] = 'utf8'"
                    ]
                },
                "Command Prompt": {
                    "path": [
                        "${env:windir}\\Sysnative\\cmd.exe",
                        "${env:windir}\\System32\\cmd.exe"
                    ],
                    "args": [],
                    "icon": "terminal-cmd"
                },
                "Git Bash": {
                    "source": "Git Bash"
                }
            },
        ```
### WSL
  - [Docker導入](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki/Docker)
  - [【WSL2】Ubuntu 20.04.4 LTS を 22.04 LTS へアップグレードした](https://zenn.dev/ryuu/articles/upgrade-ubuntu2204-wsl)

### Chrome OS Flex
  - [VS Codeで日本語入力できるようにする](https://gotoblog.org/chromebook-vscode-japanese/)
  - Could not create Moklist: Volume Full と出て起動できない
    - 何らかの原因でSecure Bootできなくなったことから、Bios / Secure Boot menuで、Delete all Secure Boot variablesを選択する
    - 起動できた後、安易にEnroll all Factory Default Keys しないほうが良い。 

### Git
  - ユーザ設定
    ```
    $ git config --global user.name "John Doe"
    $ git config --global user.email johndoe@example.com
    ```
---
##  [痕跡](_sub/Profile.md)
