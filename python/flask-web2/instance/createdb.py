import sqlite3 #sqlite3を操作するライブラリをインポート

#authorsテーブルがすでに存在する場合は削除するSQL文
DROP_AUTHORS="DROP TABLE IF EXISTS authors"

#authorsテーブルを作成するSQL文
CREATE_AUTHORS='''CREATE TABLE authors
(id INTEGER PRIMARY KEY AUTOINCREMENT,
name TEXT,
bio TEXT)'''

#authorsテーブルにデータを書き込むSQL文
INSERT_AUTHOR='''INSERT INTO authors (name, bio)
VALUES ('ニュートン',
'　「なぜリンゴが木から落ちるのかという疑問から万有引力の法則を発見した」という伝説がある')
'''

#authorsテーブルに入れたデータを検索するSQL文
SELECT_AUTHORS="SELECT * FROM authors" #authorsテーブルの全レコードを読み出す

#データベースファイルを作成して接続オブジェクトを取得
conn = sqlite3.connect('bookdb.sqlite3')

#データベースファイルに対する操作を実行
c = conn.cursor()         #カーソルオブジェクトを得る
c.execute(DROP_AUTHORS)   #DROP_AUTHORSに代入したSQL文を実行
c.execute(CREATE_AUTHORS) #CREATE_AUTHORSに代入したSQL文を実行
c.execute(INSERT_AUTHOR)  #INSERT_AUTHORに代入したSQL文を実行
conn.commit()             #データベースファイルへの書き込みを確定する

#authorsテーブルを検索して結果を出力
c.execute(SELECT_AUTHORS) #SELECT_AUTHORSに代入したSQL文を実行
result = c.fetchone()     #検索結果をひとつだけ取得する
print(result)             #取得した検索結果を出力する
