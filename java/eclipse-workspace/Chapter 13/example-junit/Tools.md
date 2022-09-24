*   Maven
    -   実行するには、そもそもMavenのプラグインが必要。

    ```xml
    <build>
        <plugins>
            <plugin>
            <artifactId>maven-compile-plugin</artifactId>
            <version>3.3</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
            </plugin>
        </plugins>
    </build>
    ```

    -   maven-site-pluginも必要。
    ```XML
    <plugin>
        <artifactId>maven-site-plugin</artifactId>
        <version>3.3</version>
    </plugin>
    ```

*   JavaDoc
    -   mvn siteを実行すると、target\site\apidocsディレクトリ配下にHTMLファイルが生成される。

*   Checkstyle
    -   mvn clean package siteを実行すると、target\site\ディレクトリ配下にHTMLファイルが生成される。

*   FindBugs
    -   mvn clean package siteを実行すると、target\site\ディレクトリ配下にHTMLファイルが生成される。

*   Jenkins
    -   2.346.2のインストール時にローカルシステムでの実行を選択するも、開始できない模様。
    -   2.361.1のインストールで開始できるようになる。
