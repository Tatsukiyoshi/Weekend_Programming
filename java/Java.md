*   Java
    -   JSTLを利用する場合、ビルドバスにJARファイルの登録が必要
        ![ビルドパスへの登録](../images/eclipse/jstl_taglib.png)
        -   [JSTLを用いたjspで起こるエラーを解決したい](https://teratail.com/questions/350891)
        -   [「http://java.sun.com/jsp/jstl/core」のタグライブラリ記述子が見つかりません　の解決方法](https://qiita.com/cuore623/items/d894ab8f986904786f12)
        -   [JSTL 1.2.5](https://mvnrepository.com/artifact/org.glassfish.web/javax.servlet.jsp.jstl/1.2.5)
        -   [JSTL coreタグライブラリの利用](https://qiita.com/sculptcat/items/53d1a3a2d3b973354085)
    -   [Java 9以降でJAXBを使用するには、外部JARが必要](https://github.com/acroquest/javabook-support/issues/49)
    -   [【Java】カレントディレクトリの取得方法](https://qiita.com/mushroominger/items/89e60847879b7e9a3ad0)
    -   [String、Date、LocalDateの変換](https://qiita.com/hryshtk/items/43991beaabbb9d587360)
    -   [Java List.add() UnsupportedOperationException](https://stackoverflow.com/questions/5755477/java-list-add-unsupportedoperationexception)<BR />
        ```java
        List<Employee> employeeList = Collections.emptyList();
        ```
        クラス名を指定せず、リストを初期化すると、リストへ追加する際にそのオブジェクトが妥当が判断できず、サポートしていないという例外が発生する。
        やっぱり、リストは、クラス名を指定して、初期化しなきゃいけないってこと。
        ```java
        List<Employee> employeeList = new ArrayList<Employee>();
        ```
    *   Servlet
        -   WebServeletアノテーションを指定する場合、web.xmlでのマッピングは不要。
            -   [itmedia](https://atmarkit.itmedia.co.jp/ait/articles/1104/12/news134.html)の記事にある通り、JSR-315仕様に準じた対応となる模様。

            ```java
            @WebServlet("/SampleServlet")
            ```

            ```xml
            <servlet-mapping>
            <servlet-name>SampleServlet</servlet-name>
            <url-pattern>/SampleServlet</url-pattern>
            </servlet-mapping>
            ```
    *   JUnit
        -   [TODO: assertEqualsでなくassertThatを使うべきケースの理解](https://torazuka.hatenablog.com/entry/20111003/junit)

    *   JavaDoc
        -   [@paramタグ](https://www.javadrive.jp/javadoc/tag/index7.html)

*   Pleiades
    *   Pleiades 2022-06およびTomcat 10.0.20での対応
        -   サーブレット等の作成は、[新規]-[その他]から行う。
    *   バージョン移行
        1.  新しいバージョンをダウンロードする
        1.  旧バージョンのフォルダを削除する
        1.  ダウンロードしたファイルを展開する
            *   Windowsでは、ZIPファイルの名前ではなく、短い名前のフォルダ配下に展開する。
        1.  eclipseを起動する。
        1.  以前使用していたワークスペースを選択した場合、「古いバージョンで作成されました。続行して、古いバージョンと互換性がない可能性があるワークスペースを更新しますか？」と確認されるので、「続行」を選択して継続する。
        1.  「-clean開始中」と出ているので待つ。
        1.  ワークスペースが表示される。
    *   エンコード設定
        -   日本語を入出力する際、実行構成の設定を行う。
            ![実行構成](../images/eclipse/eclipse_encode.png)
            -   共通タブのエンコードにて、その他を選択し、ドロップダウンリストから"MS932"を選択する。

*   Jenkins
    -   Jenkinsのセットアップ
        -   非推奨のサービス起動でセットアップできた模様。（LTS 2.361.1）
            ![ダッシュボード](../images/jenkins/Jenkins_Dashboard.png)
    -   JUnitはじめ、プラグインの確認（Java本格入門 13章）
        -   ビルド実行を確認するも、サンプルが良くないらしく、エラーになってしまう。環境としてはできているので、OKとする。
            ![ビルド実行](../images/jenkins/Jenkins_Build.png)

*   Tomcat
    -   [WindowsでインストールしたTomcatの起動ポートを変更する](https://mr-star.hatenablog.com/entry/tomcat/005)

*   H2 Database
    -   環境変数H2DRIVERSまたはCLASSPATHにH2*.jarを登録する。
    -   データベースは、"H2 Console"で作成する。ただし、Embeddedモードでしか作成できない。
