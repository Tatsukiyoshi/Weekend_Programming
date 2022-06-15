*   PostgreSQL
    -   タイムアウト時間の設定（マシン性能の問題等で、PgAdminを起動できない場合の対応）
        -   サーバとの接続がタイムアウトしているため、タイムアウト時間を延ばす
    -   コマンドラインでのSQL
        -   psqlにPATHが設定されていないので、追加する必要あり
    -   参照専用ユーザの作成
        -   データを更新することはなく、参照だけできれば良い場合
            運用時のユーザや開発者向けユーザとは別に、参照専用のユーザがあると有効
        -   PostgreSQL 14以降の場合、データの参照向けロールがあるので、そのロールを設定すればよい。
            ```
            >grant pg_read_all_data to <User>
            ```
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

