# 独学によるプログラミング演習

- [リポジトリ（Github）](https://github.com/Tatsukiyoshi/Weekend_Programming.git)
- [wiki](https://github.com/Tatsukiyoshi/Weekend_Programming/wiki)

**共通**
  - Visual Studio Code 1.72.2 <BR />
    エディタはVisual Studio Codeを中心に使っており、インストールしている拡張機能の一覧は、[VSCode拡張機能](_sub/vscodeExtensions.md)にまとめてあります。
  - GitHub Desktop 3.0.8

--- 
**documentation**
  - Markdown
    - Markdown-PDF
      PDFへの変換がタイムアウトする場合、時間を伸ばす（30000ms->60000ms）
      ```
      "markdown-pdf.StatusbarMessageTimeout": 60000
      ```
    - Marp for Visual Studio Code & Draw.io Integration
  - PlantUML
    - GraphViz Ver2.38
  - mermaid
  - swagger
  - [機密データをリポジトリから削除する](https://docs.github.com/ja/github/authenticating-to-github/removing-sensitive-data-from-a-repository)
---
**[Exercism](https://exercism.io/my/tracks)**

  テキスト３冊（[独学プログラマー](http://theselftaughtprogrammer.io/)、[はじめての Android プログラミング](http://isbn.sbcr.jp/95815)、Kotlin プログラミング）をほぼ終えたため、Kotlin プログラミングの最後に紹介されている学習サイトを取り組む。<BR>
  Exercism は、様々なプログラミング言語に対応した問題を管理し、順次ダウンロードすることで、コードを作成し、テスト実行により回答を確認できるサイト。

  ```
  exercism download --exercise=two-fer --track=kotlin
  ```

  - kotlin
    - [two-fer](https://exercism.io/my/solutions/aa2de6b105d34450b4750cae4938773a) **@2019/11/17**
    - [Hello World](https://exercism.io/my/solutions/49b7155b034142da95bc5c44c17a8c36) **@2019/11/17**
    - [Reverse String](https://exercism.io/my/solutions/cbdaaa17f5574fa58c552d37d635c681) **@2019/11/17**
    - [Leap](https://exercism.io/my/solutions/775889fd51284ed69f224e352242d625) **@2019/11/17**
    - [RNA Transcription](https://exercism.io/my/solutions/3ef66e48eb1d4e2b8766d443d34a0198) **@2019/11/20**
---
**Database & SQL**

  |環境／FW                                                     |端末      |日付      
  |-------------------------------------------------------------|----------|----------
  |[PostgreSQL 15](https://www.postgresql.org/download/windows/)|IdeaPad   |2022/10/15

  - PostgreSQL
    - postgres/pgsuper
    - PgAdmin 6.14
  - [ノウハウ](sql/database.md)
  - [データベースを作成し、テーブルを追加する](https://docs.microsoft.com/ja-jp/visualstudio/data-tools/create-a-sql-database-by-using-a-designer?view=vs-2019)
  - [大量データの作成、日付の加工](https://www.excellence-blog.com/2017/06/01/sql-server%E3%81%B8%E5%A4%A7%E9%87%8F%E3%81%AE%E3%83%87%E3%83%BC%E3%82%BF%E3%82%92%E9%AB%98%E9%80%9F%E3%81%A7%E8%BF%BD%E5%8A%A0%E3%81%99%E3%82%8B/)
---
**Python**

  |テキスト                                             |日付      |進捗状況
  |-----------------------------------------------------|----------|----
  |[独学プログラマー](http://theselftaughtprogrammer.io/)|2019/10/05|<span style="color: red;">*finished*</span>

  |環境／FW                                                   |端末       |日付      
  |-----------------------------------------------------------|-----------|----------
  |[Python 3.10.6](https://www.python.org/downloads/)         |IdeaPad    |2022/08/27
  |[Django 4.1](https://docs.djangoproject.com/ja/4.1)        |           |2022/08/27

  - [Django Tutorial](https://docs.djangoproject.com/ja/4.1/intro/tutorial01/)
    **@2022/08/27** その７ adminフォームのカスタマイズ <span style="color: red;">*finished*</span>
  - nsw
    - 202005 : 日経ソフトウェア2020年5月号 **@2020/08/10**
  - pygame2 : 5日でできる！Pythonでゲーム作成入門（日経ソフトウェア2020年5月号）
    - [ケニーのサイト](https://kenney.nl/assets/space-shooter-extension)
    - ３日目：迷路 **@2020/06/29 -> 2020/07/25**
    - ４日目：月面着陸ゲーム **@2020/07/26 -> 2020/08/01**
    - ５日目：シューティングゲーム **@2020/08/10**
  - pygame : Pygame Zero ゲームプログラミング入門（日経ソフトウェア2020年3月号）
    - jumpgame **@2020/04/11**
    - shooting **@2020/04/12**
  - reversi : PythonでAIと対戦できるリバーシを作ろう
    - データ構造とUI編（日経ソフトウェア2019年9月号）
      - **@2019/09/28**コンピュータが隅に優先して石を打つよう改良
      - **@2019/10/04**コンピュータが隅を優先して石を打つかを変更するチェックボックス追加
    - AI(人工知能編)（日経ソフトウェア2019年11月号）<BR>
      - ミニマックス法
      - アルファベータ法
  - ginza - Universal Dependenciesに基づくオープンソース日本語NLPライブラリ
    ```
    pip install "https://github.com/megagonlabs/ginza/releases/download/v1.0.2/ja_ginza_nopn-1.0.2.tgz"
    ```
  - flask - 日経ソフトウェア 2019年3月号/5月号
  - opencv - ５日でわかるOpenCVプログラミング入門（日経ソフトウェア2019年3月号特別付録２）
    ```
    pip install opencv-python
    ```
  - [鎖プログラム](https://pg-chain.com/)
---
**Kotlin**

  |テキスト                                                    |日付      |進捗状況
  |------------------------------------------------------------|----------|---
  |Spring解体新書（バッチ編）                                   |2022/08/08|*finished*
  |Kotlinプログラミング                                         |2019/11/13|*finished*
  |[はじめてのAndroidプログラミング](http://isbn.sbcr.jp/95815) |2019/10/12|*finished*

  |環境／FW                                                     |端末       |日付      
  |-------------------------------------------------------------|-----------|----------
  |IntelliJ IDEA 2022.2.3                                       |IdeaPad    |2022/10/15
  |[PostgreSQL 15](https://www.postgresql.org/download/windows/)|           |2022/10/15
  |Amazon Coretto 17.0.4.9.1                                    |           |2022/09/23
  |Android Studio Dolphin 2021.3.1 Patch 1                      |ExpertBook |2022/10/22

  - Kotlin 
    - [Spring解体新書（バッチ編）](https://www.amazon.co.jp/gp/product/B09D3ZTJTB/ref=dbs_a_def_rwt_hsch_vapi_tkin_p1_i1)
      - Intellij IDEA 2022.2.3
      - Kotlin 1.7.20
      - Amazon Coretto 17.0.4.9.1 + 言語レベル 17
      - Graal VM Java17-22.2.0
      - PostgreSQL 15
      - Spring Framework 2.7.2
    - Kotlinプログラミング
      - Android
        - Chapter 22 coroutines
        - Chapter 21 [New Character UI](https://www.bignerdranch.com/assets/solutions/activity_new_character.xml)
      - [mavenでマニフェストを作成する方法](https://www.codeflow.site/ja/article/maven__how-to-create-a-manifest-file-with-maven)
      - Hint of Challenges
        - [Tavern Challenge 19](https://forums.bignerdranch.com/t/tavern-challenge/15141/2)
        - [Challenge: Tavern.kt Part 2](https://forums.bignerdranch.com/t/challenge-tavern-kt-part-2/16695)
    - ノウハウ
      - [Lombokを利用する方法](https://stackoverflow.com/questions/60419699)
        ```
        companion object {
            private val log: Logger = LoggerFactory.getLogger(this::class.java)
        }
        ```
      - [Spring Batch+Kotlinの事例](https://nulab.com/ja/blog/nulab/spring-boot-batch/)

  - Android
    ```
    Build #AI-213.7172.25.2113.9123335, built on September 30, 2022
    Runtime version: 11.0.13+0-b1751.21-8125866 amd64
    VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
    Windows 11 10.0
    GC: G1 Young Generation, G1 Old Generation
    Memory: 1280M
    Cores: 4
    Registry:
        external.system.auto.import.disabled=true
        ide.text.editor.with.preview.show.floating.toolbar=false

    Non-Bundled Plugins:
        com.intellij.ja (213.370)
        Dart (213.7433)
        io.flutter (70.2.3)
    ```
    - Dolphin 対応
      - Gradle 7.4.2 and Android Gradle Plugin 7.3.0
      - [アップデート対応](kotlin/Android/Update_to_Dolphin.md) **@2022/09/25**
    - Chipmunk 対応
      - Gradle 7.3.3 and Android Gradle Plugin 7.2.0
    - Arctic Fox 対応として吸収すべき課題
      [更新時の修正事項詳細](kotlin/Android/Update_to_Arctic_Fox.md)を参照 **@2021/11/23** <span style="color: red;">*updated!*</span>

---
**JavaScript**

  |テキスト|日付      |進捗状況
  |--------|----------|-------
  |[Angularアプリケーションプログラミング](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/13)|2022/10/22|第9章 パイプ／ディレクティブの自作 <span style="color: red;">*finished*</span>
  |モダンJavaScriptの基本から始めるReact実践の教科書|2022/07/02|*finished*

  |コンテンツ|日付      |進捗状況
  |--------|----------|-------
  |[TypeScriptで学ぶJavaScriptフレームワーク「Vue.js」の利用法](https://codezine.jp/article/corner/878)|2022/08/13|第6回 Vue.jsでWebページをつくる際の肝！「コンポーネント」をTypeScriptで活用しよう <span style="color: red;">*finished*</span>

  1.  Windows
      |FW             |端末       |日付      
      |---------------|-----------|----------
      |Node.js 16.15.1|IdeaPad    |2022/06/05
      |React 18.2.0   |           |2022/07/02
      |Svelte 3.49.0  |           |2022/07/16
      |Angular 14.2.6 |           |2022/10/16
      |Deno 1.25.4    |           |2022/09/24
      |fresh 1.1.1    |           |2022/09/24

      |FW                  |端末       |日付      
      |--------------------|-----------|----------
      |Node.js 18.12       |ExpertBook |2022/10/26
      |React Native 0.70.1 |           |2022/10/01
      |Metro 0.72.3        |           |2022/10/01

  1.  Chrome OS Flex 106.0.5249.134（Official Build）
      |FW            |端末       |日付      
      |--------------|-----------|----------
      |Node.js 18.12 |VivoBook   |2022/10/26
      |vite 3.0.9    |           |
      |vue 3.2.38    |           |        
      |@vue/cli 5.0.8|           |

  - React
    - モダンJavaScriptの基礎から始める挫折しないためのReact入門＠Udemy
    - [Tutorial](https://ja.reactjs.org/tutorial/tutorial.html) **@2021/10/10** <span style="color: red;">*Finished!*</span>
  - Svelte
    - [SvelteとReactの基本を比較](https://www.twilio.com/blog/react-svelte-comparing-basics-jp)
  - [Deno](https://deno.land/)
    - [Deno & fresh 試してみた](js/deno.md)
  - Prisma
    - [Visual Studio Code で TypeScript の開発環境を構築する](https://maku.blog/p/ak7u3h3/)
    - [Start from scratch](https://www.prisma.io/docs/getting-started/setup-prisma/start-from-scratch)
  - Sequelize
    - [Sequelizeを使用してデータベースを操作するための基本的な情報(2020.09更新）](https://qiita.com/mima_ita/items/014dcb42872f3a10855b)
  - Angular
    - [Angular日本語ドキュメンテーション―ローカル環境とワークスペースのセットアップ](https://angular.jp/guide/setup-local)
    - vs-angular
      - VSCodeを使おう（日経ソフトウェア 2019年7月号）
      - [Angularプロジェクトの作成](https://qiita.com/KaoruIto76/items/272c7724aa8bbc45d591)
    - basic_20190223
      - AngularによるモダンWeb開発 基礎編 第2版 ダイジェスト版（日経ソフトウェア 2019年5月号 付録）
  - Vue.js
    - [TypeScriptで学ぶJavaScriptフレームワーク「Vue.js」の利用法](https://codezine.jp/article/detail/14451)
  - ml5 - 日経ソフトウェア 2019年5月号
  - jskanji - VSCodeを使おう（日経ソフトウェア 2019年7月号）
  - react-native - React Nativeでスマホアプリ開発（日経ソフトウェア 2019年7月号）<BR>
    - Expo Sample - Expoサンプルアプリ
    - AdditionCalc - 足し算アプリ
  - electron
    - [Electronでアプリケーションを作ってみよう](https://qiita.com/Quramy/items/a4be32769366cfe55778)

---
**Java**
  |テキスト                                                                                   |日付      |進捗状況
  |-------------------------------------------------------------------------------------------|----------|--------
  |[Spring解体新書（第２版）](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/17)  |2022/10/23|8章 MyBatis <span style="color: red;">*finished*</span>
  |[Spring解体新書（バッチ編）](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/16)|2022/05/07|6章 バッチ実行 <span style="color: red;">*finished*</span>
  |サーブレット＆JSP入門                                                                     |2022/10/07|*finished*
  |Java本格入門                                                                              |2022/09/25|*finished*
  
  |環境／FW                                                                                                      |端末       |日付
  |--------------------------------------------------------------------------------------------------------------|-----------|----------
  |[Pleiades All in One Eclipse Standard Edition 2022-09.20220914 (Eclipse 4.25.0 GA)](https://mergedoc.osdn.jp/)|IdeaPad    |2022/09/24
  |[OpenJDK JDK 19 General-Availability Release](https://jdk.java.net/19/)                                       |           |2022/09/24
  |[Apache Tomcat 10.0.23](https://tomcat.apache.org/download-10.cgi)                                            |           |2022/09/24
  |[Jenkins LTS 2.361.1](https://www.jenkins.io/download/lts/)                                                   |           |2022/09/24
  |Apache Maven 3.8.6                                                                                            |           |2022/06/23
  |Graal VM Java17-22.2.0                                                                                        |           |2022/09/23
  |[H2 Database 2.1.214](https://www.h2database.com/html/main.html)                                              |           |2022/10/02
  |[Spring Tool Suite 4.16.0](https://spring.io/tools)                                                           |ExpertBook |2022/10/08
  |[PostgreSQL 15](https://www.postgresql.org/download/windows/)                                                 |           |2022/10/15

  * [ノウハウ＋備忘録](java/Java.md)

---
**.NET**

  |テキスト                                                                           |日付     |進捗状況
  |----------------------------------------------------------------------------------|----------|---
  |[C++ プログラミング入門](http://examples.oreilly.com/core/)                        |2021/10/17|Chapter 6 コンストラクタおよびデストラクタを用いた優れた抽象化<span style="color: red;">*finished*</span>
  |[やさしいＣ＃第３版]                                                               |2022/07/16|*finished*

  |環境／FW                                                                                                             |端末       |日付
  |---------------------------------------------------------------------------------------------------------------------|-----------|----------
  |Visual Studio Community 2022 17.4.0 Preview 4.0 + .NET 6.0.400 Preview/.NET 7.0.100-preview.7.2.22477.23             |IdeaPad    |2022/10/23
  |Visual Studio Community 2022 17.4.0 Preview 4.0 + .NET 6.0.400 Preview/.NET 7.0.100-preview.7.2.22477.23 + .NET MAUI |ExpertBook |2022/10/23
  |Android SDK Platform 33 / Platform-Tools 33.0.2 / Android Emulator 31.2.10                                       |           |2022/07/09

  - .NET 環境情報
    ```
    dotnet --info
    ```
    ```
    .NET SDK:
    Version:   7.0.100-rc.2.22477.23
    Commit:    0a5360315a

    ランタイム環境:
    OS Name:     Windows
    OS Version:  10.0.22621
    OS Platform: Windows
    RID:         win10-x64
    Base Path:   C:\Program Files\dotnet\sdk\7.0.100-rc.2.22477.23\

    Host:
      Version:      7.0.0-rc.2.22472.3
      Architecture: x64
      Commit:       550605cc93

    .NET SDKs installed:
      7.0.100-rc.2.22477.23 [C:\Program Files\dotnet\sdk]

    .NET runtimes installed:
      Microsoft.AspNetCore.App 6.0.10 [C:\Program Files\dotnet\shared\Microsoft.AspNetCore.App]
      Microsoft.AspNetCore.App 7.0.0-rc.2.22476.2 [C:\Program Files\dotnet\shared\Microsoft.AspNetCore.App]
      Microsoft.NETCore.App 3.1.30 [C:\Program Files\dotnet\shared\Microsoft.NETCore.App]
      Microsoft.NETCore.App 5.0.17 [C:\Program Files\dotnet\shared\Microsoft.NETCore.App]
      Microsoft.NETCore.App 6.0.10 [C:\Program Files\dotnet\shared\Microsoft.NETCore.App]
      Microsoft.NETCore.App 7.0.0-rc.2.22472.3 [C:\Program Files\dotnet\shared\Microsoft.NETCore.App]
      Microsoft.WindowsDesktop.App 3.1.30 [C:\Program Files\dotnet\shared\Microsoft.WindowsDesktop.App]
      Microsoft.WindowsDesktop.App 5.0.17 [C:\Program Files\dotnet\shared\Microsoft.WindowsDesktop.App]
      Microsoft.WindowsDesktop.App 6.0.10 [C:\Program Files\dotnet\shared\Microsoft.WindowsDesktop.App]
      Microsoft.WindowsDesktop.App 7.0.0-rc.2.22472.13 [C:\Program Files\dotnet\shared\Microsoft.WindowsDesktop.App]

    Other architectures found:
      x86   [C:\Program Files (x86)\dotnet]
        registered at [HKLM\SOFTWARE\dotnet\Setup\InstalledVersions\x86\InstallLocation]

    Environment variables:
      Not set

    global.json file:
      Not found

    Learn more:
      https://aka.ms/dotnet/info

    Download .NET:
      https://aka.ms/dotnet/download
    ```
  - C#
    - [やさしいＣ＃第３版](https://isbn2.sbcr.jp/03922/)
      - [サポートページ](http://mana.on.coocan.jp/yasacs.html)
    - フリーアイコン
      - GO(https://www.flaticon.com/free-icon/go_652364)
      - GoBack(https://www.flaticon.com/free-icon/back-button_93634?term=back&page=1&position=6&page=1&position=6&related_id=93634&origin=search)
    - [アプリケーション構成ファイル](https://www.fenet.jp/dotnet/column/language/9654/)
    - ColorDialog
  - C++
    - [carbon language](https://github.com/carbon-language/carbon-lang)
      - carbon **@2022/07/31** <span style="color: red;">*Install Failed!*</span>
      - [ubuntu 2022.04 にインストール](carbon/carbon.md)
    - C11/C++17 - [C++環境設定](https://code.visualstudio.com/docs/cpp/config-msvc)
      - HelloWorld
      - [Learn C++](https://www.learncpp.com/) **@2019/10/22** 1.5 Introduction to iostream
  - Blazor
    - Blazor入門（日経ソフトウェア 2021年9月号）**@2021/09/26** <span style="color: red;">*finished*</span>

---
**Dart/flutter**

  |コンテンツ                                                                |日付     |進捗状況
  |--------------------------------------------------------------------------|---------|---
  |[Flutterで始めるモバイルアプリ開発](https://codezine.jp/article/corner/830)|2022/10/23|第13回  Flutterではマテリアルデザインを用いたコンポーネントをどう使うのか【テキスト編】 <span style="color: red;">*finished*</span>

  |環境／FW                                                     |端末       |日付
  |-------------------------------------------------------------|-----------|----------
  |[Flutter 3.3.5](https://docs.flutter.dev/get-started/install)|ExpertBook |2022/10/23

  - flutter dev
    -  [Get started](https://docs.flutter.dev/get-started/install)
    -  myapp - flutter demo
    -  Startup namer
  - flutterの更新
    ```
    flutter upgrade
    ```
  - flutter doctor -vの出力
    ```
    [√] Flutter (Channel stable, 3.3.5, on Microsoft Windows [Version 10.0.22621.675], locale ja-JP)
        • Flutter version 3.3.5 on channel stable at D:\flutter
        • Upstream repository https://github.com/flutter/flutter.git
        • Framework revision d9111f6402 (4 days ago), 2022-10-19 12:27:13 -0700
        • Engine revision 3ad69d7be3
        • Dart version 2.18.2
        • DevTools version 2.15.0

    [√] Android toolchain - develop for Android devices (Android SDK version 33.0.0)
        • Android SDK at C:\Users\taish\AppData\Local\Android\sdk
        • Platform android-33, build-tools 33.0.0
        • Java binary at: D:\Program Files\Android\Android Studio\jre\bin\java
        • Java version OpenJDK Runtime Environment (build 11.0.13+0-b1751.21-8125866)
        • All Android licenses accepted.

    [√] Chrome - develop for the web
        • Chrome at C:\Program Files\Google\Chrome\Application\chrome.exe

    [√] Visual Studio - develop for Windows (Visual Studio Community 2022 17.4.0 Preview 4.0)
        • Visual Studio at D:\Program Files\Microsoft Visual Studio\2022\Preview
        • Visual Studio Community 2022 version 17.4.33015.44
        • The current Visual Studio installation is a pre-release version. It may not be supported by Flutter yet.
        • Windows 10 SDK version 10.0.22621.0

    [√] Android Studio (version 2021.3)
        • Android Studio at D:\Program Files\Android\Android Studio
        • Flutter plugin can be installed from:
          https://plugins.jetbrains.com/plugin/9212-flutter
        • Dart plugin can be installed from:
          https://plugins.jetbrains.com/plugin/6351-dart
        • Java version OpenJDK Runtime Environment (build 11.0.13+0-b1751.21-8125866)

    [√] VS Code (version 1.72.2)
        • VS Code at C:\Users\taish\AppData\Local\Programs\Microsoft VS Code
        • Flutter extension version 3.50.0

    [√] Connected device (3 available)
        • Windows (desktop) • windows • windows-x64    • Microsoft Windows [Version 10.0.22621.675]
        • Chrome (web)      • chrome  • web-javascript • Google Chrome 105.0.5195.102
        • Edge (web)        • edge    • web-javascript • Microsoft Edge 106.0.1370.52

    [√] HTTP Host Availability
        • All required HTTP hosts are available
    ```
---
**Rust**

  1. Windows 11
      |環境／FW     |端末       |日付
      |-------------|-----------|----------
      |Rust 1.64.0  |IdeaPad    |2022/10/08
      |Tauri 1.1.1  |           |2022/09/17
      |Svelte 3.50.1|           |2022/09/17

  1. Ubuntu 20.04 on Windows 11
      |環境／FW     |端末       |日付
      |-------------|-----------|----------
      |Rust 1.64.0  |IdeaPad    |2022/10/08
      |Tauri 1.1.1  |           |2022/09/17
      |React 18.2.0 |           |2022/09/17

  1. Chrome OS Flex 106.0.5249.113（Official Build）
      |環境／FW     |端末       |日付
      |-------------|-----------|----------
      |Rust 1.64.0  |VivoBook   |2022/10/08
      |Tauri 1.1.1  |           |2022/09/17
      |React 18.2.0 |           |2022/09/03
      |Vite 3.1.6   |           |2022/10/08

  - [Build smaller, faster, and more secure desktop applications with a web frontend](https://tauri.studio/)
  - ディストリビューションのバージョンを確認する
    ```
    lsb_release -a
    ```
  - [WSL2 Ubuntu に Rust をインストールする](https://qiita.com/cointoss1973/items/a4d15b203f985baaa34e)
  - [WSL(Ubuntu)とVSCodeでRustの学習環境準備](https://qiita.com/evid/items/f81534518b30847a24d2)
    - プロジェクト作成 - cargo new --bin <プロジェクト名>
    - ビルド実行 - carg run
  - [The Rust Programming Language 日本語版](https://doc.rust-jp.rs/book-ja/)
  - [ノウハウ＋備忘録](rust/rust.md)

---
**ObjectPascal**
  - Delphi
    - CardPanelDemo
  - Lazarus(FreePascal) [Lazarus日本語情報トップページ](https://ja.osdn.net/projects/sfnet_lazarus/)/[Lazarus Tutorial](https://wiki.freepascal.org/Lazarus_Tutorial/ja)
    - Project1(Press Again)
---
**Swift**
  - コンパイル
    ```
    set SDKROOT=%SystemDrive%/Library/Developer/Platforms/Windows.platform/Developer/SDKs/Windows.sdk
    swiftc -target x86_64-unknown-windows-msvc -sdk %SDKROOT% -I %SDKROOT%/usr/lib/swift -L %SDKROOT%/usr/lib/swift/windows helloworld.swift -o helloworld.exe
    ```
---
**LLVM**
  - LLVM 12.0
    - [for Ubuntu](https://apt.llvm.org/)
      ```
      apt-get install clang-format clang-tidy clang-tools clang clangd libc++-dev libc++1 libc++abi-dev libc++abi1 libclang-dev libclang1 liblldb-dev libllvm-ocaml-dev libomp-dev libomp5 lld lldb llvm-dev llvm-runtime llvm python-clang
      ```
    - [for Winfows](https://releases.llvm.org/download.html)
  - 「きつねさんでもわかるLLVM」で学習中
    - DummyCCompiler実践中
      **@2021/01/11** : Front-End(to Chapter 5.9) finished
    - [きつねさんでもわかるLLVM公式リポジトリ](https://github.com/Kmotiko/DummyCCompiler)
---
**Unity**
  - Unity Hub 2.4.2 and Unity 2020.2.5f1
    - 「Unityによるモバイルゲーム開発」で学習中
    - [Unityによるモバイルゲーム開発リポジトリ](https://github.com/oreilly-japan/mobile-game-development-with-unity-ja)
    - [アスペクト比や解像度に合わせてUIの位置とサイズを固定する方法](https://pengoya.net/unity/ui-fix/)
---

## [痕跡](_sub/Profile.md)
