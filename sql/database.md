*   PostgreSQL
    -   PgAdmin起動できない場合、サーバとの接続がタイムアウトしているため、タイムアウト時間を延ばす

*   MySQL
    -   ZIPファイルを任意のディレクトリに展開する
    -   my.iniを展開したディレクトリに作成する
        ```ini
        [mysqld]
        # set basedir to your installation path
        basedir=D:\mysql-8.0.28-winx64
        # set datadir to the location of your data directory
        datadir=D:\mysql-8.0.28-winx64\data
        ```
    -   データディレクトリを初期化する（パスワード生成せず）
        ```
        mysqld.exe --initialize-insecure --console
        ```
    -   MySQL Server を起動する（パスワードなし）
        ```
        mysql.exe -u root --skip-password
        ```
    -   MySQLをサービスに登録する
        ```
        D:\mysql-8.0.28-winx64\bin\mysqld --install MYSQL80
        ```
    -   MySQLのサービスを開始する
        ```
        net start MYSQL80
        ```
    -   DDL
        *   rootパスワードの変更
            ```
            mysql> ALTER USER root@localhost IDENTIFIED BY "root";
            ```
        *   ユーザの追加およびパスワードの登録
            ```
            mysql> CREATE USER taish;
            mysql> ALTER USER taish@localhost IDENTIFIED BY "taishow";
            ```

