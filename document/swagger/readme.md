# Swagger
RESTful APIについて、Swagger(Open API)仕様で仕様書を作成したい。

## 環境準備
* Visual Studio Code をインストールする
  * JavaPackInstallerを使って、Adopt Open JDKをセットでインストールしてもよい。

* Visual Studio Codeの拡張機能をインストールする
  1. Swagger Editor --- swaggerでAPI仕様を作成する
  1. YAML --- Swagger Editorの依存機能
  1. swagger viewer --- API仕様書をプレビューする
  1. Markdown Preview Enhanced --- Markdown形式をプレビューする／変換する

* ドキュメント配布用に、変換ツールをインストールする
  * swagger2markup-cli --- Ascii-doc形式/Markdown形式へ変換する
    * Github リポジトリから環境を入手し、ビルドする
      ```
      $ git clone https://github.com/Swagger2Markup/swagger2markup-cli.git
      $ ./gradlew jar
      ```

    ```
    * swagger2markupをダウンロードし、任意のディレクトリに配置する
      公開サイト(http://swagger2markup.github.io/swagger2markup/1.3.1/)
    ```

  * asciidoc3 --- HTML形式へ変換する
    * Ascii-doc3をダウンロードし、任意のディレクトリに展開する
      [Windows用ZIPファイル](https://asciidoc3.org/download.html)

    * Python 3.xをダウンロードし、インストールする
      [Python3サイト](https://www.python.jp/install/windows/install_py3.html)

    * 開発ツール含むAnacondaをダウンロードし、インストールこともおすすめ。

## 作成手順

* Open APIに準じたAPI仕様書を作成する

* 作成したAPI仕様書を配布用に変換する
  * via Markdown形式
    * Markdown形式に変換する （最新バージョンは、1.3.3）
      * 設定ファイル(config.properties)を作成する

      ```
      swagger2markup.markupLanguage=MARKDOWN
      ```

      ```
      $ java -jar swagger2markup-cli-1.2.1-SNAPSHOT.jar convert -i swagger.yaml -f swagger -c .\\config.properties
      ```
      * -i swaggerファイル名
      * -f 出力ファイル名
      * -c 設定ファイル名
    
    * Markdown形式をVisual Studio Codeでプレビューする <BR>
      HTML形式などに変換も可能

  * via Ascii-doc形式
    * Ascii-doc形式に変換する （最新バージョンは、1.3.3）

      ```
      $ java -jar swagger2markup-cli-1.2.1-SNAPSHOT.jar convert -i swagger.yaml -f swagger
      ```
      * -i swaggerファイル名
      * -f 出力ファイル名

    * Ascii-doc形式からHTML形式への変換（ascii-doc）

      ```
      $ python -a asciidoc3.py doc/asciidoc.txt
      ```

  * Visual Studio CodeへCode Runnerを設定することで、変換を容易にする

    * Markdown形式
    ```
    "yaml": "cd $dir && java -jar E:\\ProgramData\\swagger2markup-cli\\swagger2markup-cli-1.3.3.jar convert -i $fileName -f $fileNameWithoutExt -c .\\config.properties"
    ```

    * Ascii-doc形式 -> HTML形式
    ```
    "yaml": "cd $dir && java -jar E:\\ProgramData\\swagger2markup-cli\\swagger2markup-cli-1.3.3.jar convert -i $fileName -f $fileNameWithoutExt && python E:\\ProgramData\\asciidoc3-3.1.0\\asciidoc3.py $fileNameWithoutExt.adoc"
    ```
