*   日本語に変える方法
    -   https://codor.co.jp/django/how-change-language

*   Djangoのソースディレクトリを確認する方法
    ```
    python -c "import django; print(django.__path__)"
    ```

*   チュートリアル
    *   サーバ起動
        ```
        python manage.py runserver
        ```
    *   SHELLでの確認
        ```
        python manage.py shell
        ```
    *   テストコードの実行
        ```
        python manage.py test polls
        ```
    *   URL
        サイト|パス
        ------|----
        投票  |localhost:8000/polls
        管理  |localhost:8000/admin

        *   管理サイトのパスワード
            admin / djangoadmin
