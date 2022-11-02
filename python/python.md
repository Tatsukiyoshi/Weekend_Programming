*   python インストール後の対応
    -   下記をPATHに追加する。
        ```
        C:\Users\taish\AppData\Local\Programs\Python\Python311\Scripts
        ```
    -   Djangoをインストールする
        ```
        python -m pip install django
        ```
*   Django
    *   日本語に変える方法
        -   https://codor.co.jp/django/how-change-language
    *   Djangoのソースディレクトリを確認する方法
        ```
        python -c "import django; print(django.__path__)"
        ```
    *   Djangoのバージョン確認
        ```
        python -m django --version
        ```
    *   Djangoのアップグレード
        ```
        python -m pip install --upgrade Django
        ```
    *   Python/Djangoのテスト
        ```
        python -Wa manage.py test
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
