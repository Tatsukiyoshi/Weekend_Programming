import sqlite3
from flask import current_app, g

def get_db(): #データベースに接続して接続情報を得る
    if 'db' not in g:
        g.db = sqlite3.connect(
            current_app.config['DATABASE'],
            detect_types = sqlite3.PARSE_DECLTYPES
        )
        g.db.row_factory = sqlite3.Row
        # データベースの列の値をディクショナリの形で読み込む
    return g.db

def close_db(e=None): #データベース接続を解除する
    db = g.pop('db', None)
    if db is not None:
        db.close()

def init_app(app): #アプリの初期化
    app.teardown_appcontext(close_db)
    # 「ページを読み込み終えたらclose_dbを呼ぶ」という設定
