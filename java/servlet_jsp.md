*   Servletについて
    -   サーブレット等の作成は、[新規]-[その他]から行う。
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
