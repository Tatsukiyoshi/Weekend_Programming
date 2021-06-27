import sqlite3

#booksテーブルを作成するSQL文
DROP_BOOKS="DROP TABLE IF EXISTS books"
CREATE_BOOKS='''CREATE TABLE books
(id INTEGER PRIMARY KEY AUTOINCREMENT,
title TEXT,
author TEXT,
cover TEXT DEFAULT 'book.png')''' #初期値を設定

#データベース操作を実行
conn = sqlite3.connect('bookdb.sqlite3')
c = conn.cursor()
c.execute(DROP_BOOKS)
c.execute(CREATE_BOOKS) #まだデータを入れない
conn.commit()
conn.close()
