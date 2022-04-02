* ZIPファイルを任意のディレクトリに展開する
* my.iniを展開したディレクトリに作成する

```
[mysqld]
# set basedir to your installation path
basedir=D:\mysql-8.0.28-winx64
# set datadir to the location of your data directory
datadir=D:\mysql-8.0.28-winx64\data
```

* データディレクトリを初期化する（パスワード生成せず）

```
mysqld.exe --initialize-insecure --console
```

* MySQL Server を起動する（パスワードなし）

```
mysql.exe -u root --skip-password
```

* rootパスワードの変更

```
mysql> ALTER USER root@localhost IDENTIFIED BY "root";
```

* ユーザの追加およびパスワードの登録

```
mysql> CREATE USER taish;
mysql> ALTER USER taish@localhost IDENTIFIED BY "taishow";
```
