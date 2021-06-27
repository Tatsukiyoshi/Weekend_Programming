# モジュールsqlite3をインポート
import sqlite3

# 表を定義するCREATE TABLE文
CREATE_TABLE = '''CREATE TABLE books
(id INTEGER PRIMARY KEY AUTOINCREMENT,
author TEXT,
title TEXT)'''

# 1行を挿入するINSERT文
TEST_INSERT = '''INSERT INTO books (title, author)
VALUES ('プリンキピア','ニュートン')
'''

# 表から全データを選択するSELECT文
TEST_SELECT = "SELECT * FROM books"

# データベースへの接続（存在しない場合は、新規に作成する）
# 拡張子は仮に"sqlite3"とする
conn = sqlite3.connect('testdb.sqlite3')

# カーソルオブジェクト取得
c = conn.cursor()

# 表を定義する
c.execute(CREATE_TABLE)

# 1行を挿入する
c.execute(TEST_INSERT)

# データ書き込みを確定する
conn.commit()

# 表を検索する
c.execute(TEST_SELECT)

# 検索結果を1つ取得し、出力する
result = c.fetchone()
print(result)

# データベースへの接続を閉じる
conn.close()
