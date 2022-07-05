# 独学によるプログラミング演習

## [リポジトリ（Github）](https://github.com/Tatsukiyoshi/Weekend_Programming.git)

## ヘッドライン
### 演習進捗
|日付      |演習対象|テキスト|進捗状況|
|----------|------ |-------|--------|
|2022/07/02|React  |[モダンJavaScriptの基本から始めるReact実践の教科書](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/12)| <span style="color: red;">*finished*</span>|
|2022/06/26|Angular|[Angularアプリケーションプログラミング](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/13)|第3章 データバインディング <span style="color: red;">*finished*</span>|
|2022/06/25|C#     |[やさしいＣ＃第３版](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/18)|Lesson 12 データの利用 <span style="color: red;">*finished*</span>|
|2022/06/19|Kotlin |[Spring解体新書（バッチ編）](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/16)|9.2 MyBatis <span style="color: red;">*finished* by Kotlin</span>|
|2022/06/18|Java   |[Java本格入門](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/14)|Chapter 10 オブジェクト指向をたしなむ <span style="color: red;">*started*</span>|
|2022/06/04|Java   |[サーブレット＆JSP入門](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/15)|3章 サーブレットの基礎 <span style="color: red;">*redo finished*</span>|
|2022/05/07|Java   |[Spring解体新書（バッチ編）](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/16)|6章 バッチ実行 <span style="color: red;">*finished* by Java</span>|
|2022/05/04|Java   |[Spring解体新書（第２版）](https://github.com/Tatsukiyoshi/Weekend_Programming/issues/17)|3章 Hello World・・・簡単なサンプル <span style="color: red;">*finished*</span>|

### 環境アップデート
|ソフトウェア    |端末        |日付      |詳細    
|---------------|-----------|-----------|----
|Visual Studio  |IdeaPad    |2022/06/18|Visual Studio 2022 17.3.0 Preview 2.0 + .NET 6.0.400 Preview/.NET 7.0.100 Preview
|               |ExpertBook |2022/06/06|Visual Studio Community 2022 17.3.0 + .NET 6 + MAUI
|               |           |2022/06/06|Android SDK Platform 31
|Kotlin         |IdeaPad    |2022/07/05|IntelliJ IDEA 2022.1.3
|               |           |2022/06/08|[PostgreSQL 14.3](https://www.postgresql.org/download/windows/)
|Java           |IdeaPad    |2022/06/03|[Pleiades All in One Eclipse Standard Edition 2022-06.20220515 (Eclipse 4.24.0 M2)](https://mergedoc.osdn.jp/)
|               |           |2022/06/04|[OpenJDK JDK 18.0.1.1 General-Availability Release](https://jdk.java.net/18/)
|               |           |2022/06/04|Apache Tomcat 10.0.20
|               |ExpertBook |2022/05/04|[Spring Tool Suite 4.14.1](https://spring.io/tools)
|               |           |2022/05/05|[PostgreSQL 14.2](https://www.postgresql.org/download/windows/)
|React          |IdeaPad    |2022/06/05|React 18.2.0
|               |           |2022/06/05|Node.js 16.15.1
|Svelte         |IdeaPad    |2022/06/05|Svelte 3.44.3
|Angular        |IdeaPad    |2022/06/09|Angular 14.0.1
|Android Studio |ExpertBook |2022/05/11|Android Studio Chipmunk 2021.2.1
|Flutter        |ExpertBook |2022/05/25|Flutter 3.01
|Rust(Windows)  |IdeaPad    |2022/07/05|Rust 1.62.0 on Windows 11
|               |           |2022/06/17|Tauri 1.0.0 on Windows 11
|Rust(Ubuntu)   |IdeaPad    |2022/06/09|Ubuntu 22.04 LTS
|               |           |2022/06/09|Rust 1.61.0 on Ubuntu 22.04 LTS
|               |           |2022/06/11|Tauri 1.0.0-rc.14 on Ubuntu 22.04 LTS
|               |           |2022/06/11|React 18.1.0 on Ubuntu 22.04 LTS
|Python         |IdeaPad    |2022/06/09|[Python 3.10.5](https://www.python.org/downloads/)
|               |           |2022/06/06|[Django 4.0.5](https://docs.djangoproject.com/ja/4.0/intro/install/)

#### [VSCode拡張機能](./vscodeExtensions.md)

## 目次
<!-- @import "[TOC]" {cmd="toc" depthFrom=3 depthTo=6 orderedList=false} -->

<!-- code_chunk_output -->
- [演習進捗](#演習進捗)
- [環境アップデート](#環境アップデート)
  - [VSCode拡張機能](#vscode拡張機能vscodeextensionsmd)
- [documentation](#documentation)
- [Exercism](#exercismhttpsexercismiomytracks)
- [Database & SQL](#database-sql)
- [Python](#python)
- [Kotlin](#kotlin)
- [JavaScript](#javascript)
- [Java](#java)
- [.NET Framework / C# / C++](#net-framework-c-c)
  - [C#](#c)
  - [C++](#c-1)
  - [Blazor](#blazor)
- [Dart - flutter](#dart-flutter)
- [Rust](#rust)
- [ObjectPascal](#objectpascal)
- [Swift](#swift)
- [LLVM](#llvm)
- [Unity](#unity)
<!-- /code_chunk_output -->

--- 
### documentation
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

### [Exercism](https://exercism.io/my/tracks)

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

### Database & SQL
- [PostgreSQL 14.3](https://www.postgresql.org/download/windows/) @2022/06/08 <span style="color: red;">*Installed*</span> on IdeaPad
- ノウハウ
  - [Database関連](./sql/database.md)
  - [データベースを作成し、テーブルを追加する](https://docs.microsoft.com/ja-jp/visualstudio/data-tools/create-a-sql-database-by-using-a-designer?view=vs-2019)
  - [大量データの作成、日付の加工](https://www.excellence-blog.com/2017/06/01/sql-server%E3%81%B8%E5%A4%A7%E9%87%8F%E3%81%AE%E3%83%87%E3%83%BC%E3%82%BF%E3%82%92%E9%AB%98%E9%80%9F%E3%81%A7%E8%BF%BD%E5%8A%A0%E3%81%99%E3%82%8B/)

### Python
- [Django Tutorial](https://docs.djangoproject.com/ja/4.0/intro/tutorial01/)
  **@2021/12/16** その３ <span style="color: red;">*finished*</span>

- nsw
  - 202005 : 日経ソフトウェア2020年5月号 **@2020/8/10**

- pygame2 : 5日でできる！Pythonでゲーム作成入門（日経ソフトウェア2020年5月号）
  - [ケニーのサイト](https://kenney.nl/assets/space-shooter-extension)
  - ３日目：迷路 **@2020/6/29 -> 2020/7/25**
  - ４日目：月面着陸ゲーム **@2020/7/26 -> 2020/8/1**
  - ５日目：シューティングゲーム **@2020/8/10**

- pygame : Pygame Zero ゲームプログラミング入門（日経ソフトウェア2020年3月号）
  - jumpgame **@2020/4/11**
  - shooting **@2020/4/12**

- reversi : PythonでAIと対戦できるリバーシを作ろう
  - データ構造とUI編（日経ソフトウェア2019年9月号）
    **@2019/9/28**コンピュータが隅に優先して石を打つよう改良
    **@2019/10/4**コンピュータが隅を優先して石を打つかを変更するチェックボックス追加
  - AI(人工知能編)（日経ソフトウェア2019年11月号）<BR>
    - ミニマックス法
    - アルファベータ法

- self-taught [独学プログラマー](http://theselftaughtprogrammer.io/) **@2019/10/5:Chapter 22** <span style="color: red;">*finished!*</span>

- ginza - Universal Dependenciesに基づくオープンソース日本語NLPライブラリ
  ```
  pip install "https://github.com/megagonlabs/ginza/releases/download/v1.0.2/ja_ginza_nopn-1.0.2.tgz"
  ```

- flask - 日経ソフトウェア 2019年3月号/5月号

- opencv - ５日でわかるOpenCVプログラミング入門（日経ソフトウェア2019年3月号特別付録２）
  ```
  pip install opencv-python
  ```
  [鎖プログラム](https://pg-chain.com/)

### Kotlin
- Android Studio Chipmunk | 2021.2.1 @2022/05/11 <span style="color: red;">*Updated!*</span> On ExpertBook
  ```
  Build #AI-212.5712.43.2112.8512546, built on April 29, 2022
  Runtime version: 11.0.12+7-b1504.28-7817840 amd64
  VM: OpenJDK 64-Bit Server VM by Oracle Corporation
  Windows 10 10.0
  GC: G1 Young Generation, G1 Old Generation
  Memory: 1280M
  Cores: 4
  Registry: external.system.auto.import.disabled=true
  Non-Bundled Plugins: Dart (212.5744), org.jetbrains.kotlin (212-1.6.21-release-334-AS5457.46), io.flutter (67.1.2)
  ```
- Chipmunk 対応
  - Gradle 7.3.3 and Android Gradle Plugin 7.2.0
- Arctic Fox 対応として吸収すべき課題
  [更新時の修正事項詳細](./kotlin/Android/Update_to_Arctic_Fox.md)を参照 **@2021/11/23** <span style="color: red;">*updated!*</span>

- Android - はじめてのAndroidプログラミング **@2019/10/12** My Scheduler(Chapter 12) <span style="color: red;">*finished!*</span>
  - [サンプル](http://isbn.sbcr.jp/95815)

- Programming 
  - [Spring解体新書（バッチ編）](https://www.amazon.co.jp/gp/product/B09D3ZTJTB/ref=dbs_a_def_rwt_hsch_vapi_tkin_p1_i1) **@2022/07/05** 9.3.1 JpaCursorItemReader <span style="color: red;">*finished*</span>
    - Intellij IDEA 2022.1.3
    - Amazon Coretto 17.0.3 + 言語レベル 8
    - PostgreSQL 14.3

    - ノウハウ
      - [Lombokを利用する方法](https://stackoverflow.com/questions/60419699)
        ```
        companion object {  // 
            private val log: Logger = LoggerFactory.getLogger(this::class.java)
        }
        ```
      - [Spring Batch+Kotlinの事例](https://nulab.com/ja/blog/nulab/spring-boot-batch/)

  - Kotlinプログラミング **@2019/11/13** Chapter 22(coroutines sample update for kotlin1.3)
    - Android
      - Chapter 22 coroutines
      - Chapter 21 [New Character UI](https://www.bignerdranch.com/assets/solutions/activity_new_character.xml)
    - [mavenでマニフェストを作成する方法](https://www.codeflow.site/ja/article/maven__how-to-create-a-manifest-file-with-maven)
    - Hint of Challenges
      - [Tavern Challenge 19](https://forums.bignerdranch.com/t/tavern-challenge/15141/2)
      - [Challenge: Tavern.kt Part 2](https://forums.bignerdranch.com/t/challenge-tavern-kt-part-2/16695)

### JavaScript
- Angular 14.0.1 (Node.js 16.15.1) @2022/06/09 <span style="color: red;">*Updated!*</span>on IdeaPad
  - [Angularアプリケーションプログラミング](http://www.wings.msn.to/index.php/-/A-03/978-4-7741-9130-0/) **@2022/07/01** 4.2 ディレクティブ <span style="color: red;">*started*</span>
  - [Angular日本語ドキュメンテーション―ローカル環境とワークスペースのセットアップ](https://angular.jp/guide/setup-local)
  - 日経ソフトウェア 2019年5月号

- React 18.2.0 (Node.js 16.15.1) @2022/07/02 <span style="color: red;">*Updated!*</span>on IdeaPad
  - [モダンJavaScriptの基本から始めるReact実践の教科書](https://isbn2.sbcr.jp/10722/) **@2022/07/02** Appendix React × TypeScript実践演習 <span style="color: red;">*finished*</span>
  - モダンJavaScriptの基礎から始める挫折しないためのReact入門＠Udemy
  - [Tutorial](https://ja.reactjs.org/tutorial/tutorial.html) @2021/10/10 <span style="color: red;">*Finished!*</span>

- Svelte 3.44.3 (Node.js 16.15.1) @2022/06/05 <span style="color: red;">*Installed!*</span>on IdeaPad
  - [SvelteとReactの基本を比較](https://www.twilio.com/blog/react-svelte-comparing-basics-jp)

- Prisma
  - [Visual Studio Code で TypeScript の開発環境を構築する](https://maku.blog/p/ak7u3h3/)
  - [Start from scratch](https://www.prisma.io/docs/getting-started/setup-prisma/start-from-scratch)

- Sequelize
  - [Sequelizeを使用してデータベースを操作するための基本的な情報(2020.09更新）](https://qiita.com/mima_ita/items/014dcb42872f3a10855b)

- ml5 - 日経ソフトウェア 2019年5月号

- jskanji - VSCodeを使おう（日経ソフトウェア 2019年7月号）

- vs-angular - VSCodeを使おう（日経ソフトウェア 2019年7月号）[Angularプロジェクトの作成](https://qiita.com/KaoruIto76/items/272c7724aa8bbc45d591)

- react-native - React Nativeでスマホアプリ開発（日経ソフトウェア 2019年7月号）<BR>
  - Expo Sample - Expoサンプルアプリ
  - AdditionCalc - 足し算アプリ

- electron
  - [Electronでアプリケーションを作ってみよう](https://qiita.com/Quramy/items/a4be32769366cfe55778)

### Java
- [PostgreSQL 14.2](https://www.postgresql.org/download/windows/) @2022/05/05 <span style="color: red;">*Installed*</span> on ExpertBook
  postgres/pgsuper
- [Spring Tool Suite 4.14.1](https://spring.io/tools) @2022/05/04 <span style="color: red;">*Installed!*</span> on ExpertBook
- IntelliJ IDEA 2022.1 @2022/04/13 <span style="color: red;">*Updated!*</span> on TransBook
- [Pleiades All in One Eclipse](https://mergedoc.osdn.jp/) 2022-06 @2022/06/03 <span style="color: red;">*Updated!*</span>

- [Spring解体新書（バッチ編）](https://www.amazon.co.jp/gp/product/B09D3ZTJTB/ref=dbs_a_def_rwt_hsch_vapi_tkin_p1_i1) **@2022/05/07** 6章 バッチ実行 <span style="color: red;">*finished*</span>

- [Spring解体新書（第２版）](https://www.amazon.co.jp/gp/product/B08XPBPH9C/ref=dbs_a_def_rwt_hsch_vapi_tkin_p1_i0) **@2022/05/04** 3章 Hello World・・・簡単なサンプル <span style="color: red;">*finished*</span>

- [Java本格入門](https://gihyo.jp/book/2017/978-4-7741-8909-3) **@2022/06/18** Chapter 10 オブジェクト指向をたしなむ<span style="color: red;">*started*</span>
  - [Java 9以降でJAXBを使用するには、外部JARが必要](https://github.com/acroquest/javabook-support/issues/49)
- [サーブレット＆JSP入門](https://sukkiri.jp/books/sukkiri_servlet2) **@2022/06/04** : 3章 サーブレットの基礎 <span style="color: red;">*redo finished*</span>
  - [Pleiades 2022-06 & Tomcat 10.0.20での対応](java/pleiades.md)

### .NET Framework / C# / C++
- Visual Studio 2022 17.3.0 Preview 2.0 + .NET 6.0.400 Preview/.NET 7.0.100 Preview @2022/06/18 <span style="color: red;">*Updated!*</span>
- Visual Studio 2022 17.3.0 Preview 1.1 + .NET 6 + MAUI + Android SDK Platform 31 @2022/06/06 <span style="color: red;">*Installed!*</span>

#### C#
  - [やさしいＣ＃第３版](https://isbn2.sbcr.jp/03922/) **@2022/06/25** : Lesson 12 データの利用 <span style="color: red;">*finished*</span>
    - [サポートページ](http://mana.on.coocan.jp/yasacs.html)
  - フリーアイコン
    - GO(https://www.flaticon.com/free-icon/go_652364)
    - GoBack(https://www.flaticon.com/free-icon/back-button_93634?term=back&page=1&position=6&page=1&position=6&related_id=93634&origin=search)
  - [アプリケーション構成ファイル](https://www.fenet.jp/dotnet/column/language/9654/)
  - ColorDialog

#### C++
  - [C++ プログラミング入門](http://examples.oreilly.com/core/) **@2021/10/06** <span style="color: green;">Chapter 6.2 デストラクタ</span>

  - C11/C++17 - [C++環境設定](https://code.visualstudio.com/docs/cpp/config-msvc)
    - HelloWorld
    - [Learn C++](https://www.learncpp.com/) **@2019/10/22** 1.5 Introduction to iostream

#### Blazor
  - Blazor入門（日経ソフトウェア 2021年9月号）**2021/9/26** <span style="color: red;">*finished*</span>

### Dart - flutter
- Flutter 3.01 @2022/05/22 <span style="color: red;">*Updated!*</span> On ExpertBook
- flutter dev [Get started](https://docs.flutter.dev/get-started/install)
  - myapp - flutter demo
  - Startup namer

### Rust
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

### ObjectPascal
- Delphi
  - CardPanelDemo

- Lazarus(FreePascal) [Lazarus日本語情報トップページ](https://ja.osdn.net/projects/sfnet_lazarus/)/[Lazarus Tutorial](https://wiki.freepascal.org/Lazarus_Tutorial/ja)
  - Project1(Press Again)

### Swift
- コンパイル
  ```
  set SDKROOT=%SystemDrive%/Library/Developer/Platforms/Windows.platform/Developer/SDKs/Windows.sdk
  swiftc -target x86_64-unknown-windows-msvc -sdk %SDKROOT% -I %SDKROOT%/usr/lib/swift -L %SDKROOT%/usr/lib/swift/windows helloworld.swift -o helloworld.exe
  ```
### LLVM
- LLVM 12.0
  - [for Ubuntu](https://apt.llvm.org/)
    ```
    apt-get install clang-format clang-tidy clang-tools clang clangd libc++-dev libc++1 libc++abi-dev libc++abi1 libclang-dev libclang1 liblldb-dev libllvm-ocaml-dev libomp-dev libomp5 lld lldb llvm-dev llvm-runtime llvm python-clang
    ```
  - [for Winfows](https://releases.llvm.org/download.html)

- 「きつねさんでもわかるLLVM」で学習中
  - DummyCCompiler実践中
    **2021/01/11** : Front-End(to Chapter 5.9) finished
  - [きつねさんでもわかるLLVM公式リポジトリ](https://github.com/Kmotiko/DummyCCompiler)

### Unity
- Unity Hub 2.4.2 and Unity 2020.2.5f1
  - 「Unityによるモバイルゲーム開発」で学習中
  - [Unityによるモバイルゲーム開発リポジトリ](https://github.com/oreilly-japan/mobile-game-development-with-unity-ja)
  - [アスペクト比や解像度に合わせてUIの位置とサイズを固定する方法](https://pengoya.net/unity/ui-fix/)

## [痕跡](Profile.md)
