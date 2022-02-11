# 独学によるプログラミング演習

## [リポジトリ（Github）](https://github.com/Tatsukiyoshi/Weekend_Programming.git)

## ヘッドライン

### 演習進捗
* 2022/02/06 [モダンJavaScriptの基本から始めるReact実践の教科書](https://isbn2.sbcr.jp/10722/)  Chapter 3 JavaScriptでのDOM操作 <span style="color: red;">*finished*</span>
* 2022/01/23 [サーブレット＆JSP入門](https://sukkiri.jp/books/sukkiri_servlet2) Chapter 8 セッションスコープ <span style="color: red;">*finished*</span>
* 2022/01/23 やさしいＣ＃ Lesson 10 ファイル <span style="color: red;">*finished*</span>
* 2021/12/22 [Java本格入門](https://gihyo.jp/book/2017/978-4-7741-8909-3) Chapter 9 日付処理を極める <span style="color: red;">*finished*</span>

### 環境アップデート
* 2022/02/11 Flutter 2.10 + Visual Studio 2022 17.1 Preview 6.0<span style="color: red;">*Updated!*</span> On ExpertBook
* 2022/02/11 Visual Studio 2022 17.1 Preview 6.0 + .NET 5 Or .NET 6 <span style="color: red;">*Updated!*</span> On TransBook
* 2022/01/01 React (Node.js 16.13.0 + react 17.0.2) <span style="color: red;">*Updated!*</span> On Expertbook
* 2022/01/01 Svelte (Node.js 16.13.0 + svelte 3.0.0) <span style="color: red;">*Updated!*</span> On Expertbook
* 2021/12/25 Android Studio Arctic Fox | 2020.3.1 Patch 4 <span style="color: red;">*Updated!*</span> On ExpertBook
* 2021/12/18 Pleiades All in One Eclipse 2021-12 (Eclipse 4.22) <span style="color: red;">*Updated!*</span> On TransBook
* 2021/12/15 Python 3.10.1 and Django 4.0 <span style="color: red;">*Installed!*</span> On ExpertBook

## 目次
<!-- @import "[TOC]" {cmd="toc" depthFrom=3 depthTo=6 orderedList=false} -->

<!-- code_chunk_output -->

- [演習進捗](#演習進捗)
- [環境アップデート](#環境アップデート)
- [documentation](#documentation)
- [Exercism](#exercismhttpsexercismiomytracks)
- [Python](#python)
- [Kotlin](#kotlin)
  - [Arctic Fox 対応として吸収すべき課題](#arctic-fox-対応として吸収すべき課題)
  - [Android - はじめてのAndroidプログラミング <br>](#android-はじめてのandroidプログラミング-br)
  - [Programming - Kotlinプログラミング <br>](#programming-kotlinプログラミング-br)
- [JavaScript](#javascript)
- [Java](#java)
  - [Java本格入門 **@2021/12/22** Chapter 9 日付処理を極める *finished*](#java本格入門httpsgihyojpbook2017978-4-7741-8909-3-20211222-chapter-9-日付処理を極める-span-stylecolor-redfinishedspan)
  - [サーブレット＆JSP入門 **@2021/12/13** : Chapter 7 リクエストスコープ *finished*](#サーブレットjsp入門httpssukkirijpbookssukkiri_servlet2-20211213-chapter-7-リクエストスコープ-span-stylecolor-redfinishedspan)
- [.NET Framework / C++](#net-framework-c)
  - [Blazor](#blazor)
    - [Blazor入門（日経ソフトウェア 2021年9月号）**2021/9/26** *finished*](#blazor入門日経ソフトウェア-2021年9月号2021926-span-stylecolor-redfinishedspan)
  - [C#](#c)
    - [やさしいＣ＃第３版 **@2021/11/23** : Lesson 9 ゲーム *finished*](#やさしいc第3版httpsisbn2sbcrjp03922-20211123-lesson-9-ゲーム-span-stylecolor-redfinishedspan)
  - [C++](#c-1)
    - [C++ プログラミング入門 **@2021/10/06** Chapter 6.2 デストラクタ](#c-プログラミング入門httpexamplesoreillycomcore-20211006-span-stylecolor-greenchapter-62-デストラクタspan)
- [ObjectPascal](#objectpascal)
- [Dart - flutter](#dart-flutter)
- [Rust on WSL 2 Ubuntu 2020.04](#rust-on-wsl-2-ubuntu-202004)
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

- self-taught [独学プログラマー](http://theselftaughtprogrammer.io/)
**@2019/10/5:Chapter 22** <span style="color: red;">*finished!*</span>
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
#### Arctic Fox 対応として吸収すべき課題
  [更新時の修正事項詳細](./kotlin/Android/Update_to_Arctic_Fox.md)を参照 **@2021/11/23** <span style="color: red;">*updated!*</span>
  - Android Studio Arctic Fox | 2020.3.1 Patch 4 (based IntelliJ 2020.3)
    ```
    Build #AI-203.7717.56.2031.7935034, built on November 21, 2021
    Runtime version: 11.0.10+0-b96-7249189 amd64
    VM: OpenJDK 64-Bit Server VM by Oracle Corporation
    Windows 10 10.0
    GC: G1 Young Generation, G1 Old Generation
    Memory: 1280M
    Cores: 4
    Registry: external.system.auto.import.disabled=true
    Non-Bundled Plugins: org.jetbrains.kotlin
    ```
#### Android - はじめてのAndroidプログラミング <br>
  **@2019/10/12** My Scheduler(Chapter 12) <span style="color: red;">*finished!*</span>
  - [サンプル](http://isbn.sbcr.jp/95815)
#### Programming - Kotlinプログラミング <br>
  **@2019/11/13** Chapter 22(coroutines sample update for kotlin1.3)
  - Android
    - Chapter 22 coroutines
    - Chapter 21 [New Character UI](https://www.bignerdranch.com/assets/solutions/activity_new_character.xml)
  - [mavenでマニフェストを作成する方法](https://www.codeflow.site/ja/article/maven__how-to-create-a-manifest-file-with-maven)
  - Hint of Challenges
    - [Tavern Challenge 19](https://forums.bignerdranch.com/t/tavern-challenge/15141/2)
    - [Challenge: Tavern.kt Part 2](https://forums.bignerdranch.com/t/challenge-tavern-kt-part-2/16695)

### JavaScript
- Svelte (Node.js 16.13.0 + svelte 3.0.0) @2022/01/01 <span style="color: red;">*Installed!*</span>on Expertbook
  - [SvelteとReactの基本を比較](https://www.twilio.com/blog/react-svelte-comparing-basics-jp)
- React (Node.js 16.13.0 + react 17.0.2) @2021/11/17 <span style="color: red;">*Updated!*</span>on Vivobook
  - [モダンJavaScriptの基本から始めるReact実践の教科書](https://isbn2.sbcr.jp/10722/) **@2022/02/06** Chapter 3 JavaScriptでのDOM操作 <span style="color: red;">*finished*</span>
  - モダンJavaScriptの基礎から始める挫折しないためのReact入門＠Udemy
  - [Tutorial](https://ja.reactjs.org/tutorial/tutorial.html) @2021/10/10 <span style="color: red;">*Finished!*</span>
- Angular - 日経ソフトウェア 2019年5月号
- ml5 - 日経ソフトウェア 2019年5月号
- jskanji - VSCodeを使おう（日経ソフトウェア 2019年7月号）
- vs-angular - VSCodeを使おう（日経ソフトウェア 2019年7月号）[Angularプロジェクトの作成](https://qiita.com/KaoruIto76/items/272c7724aa8bbc45d591)
- react-native - React Nativeでスマホアプリ開発（日経ソフトウェア 2019年7月号）<BR>
  - Expo Sample - Expoサンプルアプリ
  - AdditionCalc - 足し算アプリ
- electron
  - [Electronでアプリケーションを作ってみよう](https://qiita.com/Quramy/items/a4be32769366cfe55778)

### Java
- [Pleiades All in One Eclipse](https://mergedoc.osdn.jp/) 2021-12 @2021/11/28 <span style="color: red;">*Updated!*</span>
  - Eclipse IDE for Java Developers 2021-09
- IntelliJ IDEA 2021.2.2 @2021/09/19 <span style="color: red;">*Updated!*</span>

#### [Java本格入門](https://gihyo.jp/book/2017/978-4-7741-8909-3) **@2021/12/22** Chapter 9 日付処理を極める <span style="color: red;">*finished*</span>

- [Java 9以降でJAXBを使用するには、外部JARが必要](https://github.com/acroquest/javabook-support/issues/49)

#### [サーブレット＆JSP入門](https://sukkiri.jp/books/sukkiri_servlet2) **@2022/01/23** : Chapter 8 セッションスコープ <span style="color: red;">*finished*</span>

### .NET Framework / C++
- Visual Studio 2022 17.1 Preview 3.0 + .NET 5 Or .NET 6 @2022/1/21 <span style="color: red;">*Updated!*</span>
#### Blazor
##### Blazor入門（日経ソフトウェア 2021年9月号）**2021/9/26** <span style="color: red;">*finished*</span>
#### C#
##### [やさしいＣ＃第３版](https://isbn2.sbcr.jp/03922/) **@2022/01/23** : Lesson 10 ファイル <span style="color: red;">*finished*</span>
  [サポートページ](http://mana.on.coocan.jp/yasacs.html)
- [アプリケーション構成ファイル](https://www.fenet.jp/dotnet/column/language/9654/)
- ColorDialog
- SQL
  - [データベースを作成し、テーブルを追加する](https://docs.microsoft.com/ja-jp/visualstudio/data-tools/create-a-sql-database-by-using-a-designer?view=vs-2019)
  - [大量データの作成、日付の加工](https://www.excellence-blog.com/2017/06/01/sql-server%E3%81%B8%E5%A4%A7%E9%87%8F%E3%81%AE%E3%83%87%E3%83%BC%E3%82%BF%E3%82%92%E9%AB%98%E9%80%9F%E3%81%A7%E8%BF%BD%E5%8A%A0%E3%81%99%E3%82%8B/)
#### C++
##### [C++ プログラミング入門](http://examples.oreilly.com/core/) **@2021/10/06** <span style="color: green;">Chapter 6.2 デストラクタ</span>

  - C11/C++17 - [C++環境設定](https://code.visualstudio.com/docs/cpp/config-msvc)
    - HelloWorld
    - [Learn C++](https://www.learncpp.com/) **@2019/10/22** 1.5 Introduction to iostream

### ObjectPascal
- Delphi
  - CardPanelDemo
- Lazarus(FreePascal) [Lazarus日本語情報トップページ](https://ja.osdn.net/projects/sfnet_lazarus/)/[Lazarus Tutorial](https://wiki.freepascal.org/Lazarus_Tutorial/ja)
  - Project1(Press Again)

### Dart - flutter
- flutter dev [Get started](https://docs.flutter.dev/get-started/install)
  - myapp - flutter demo
  - Startup namer

### Rust on WSL 2 Ubuntu 2020.04
- [WSL2 Ubuntu に Rust をインストールする](https://qiita.com/cointoss1973/items/a4d15b203f985baaa34e)
- [WSL(Ubuntu)とVSCodeでRustの学習環境準備](https://qiita.com/evid/items/f81534518b30847a24d2)
  - プロジェクト作成 - cargo new --bin <プロジェクト名>
  - ビルド実行 - carg run
- [The Rust Programming Language 日本語版](https://doc.rust-jp.rs/book-ja/)

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
