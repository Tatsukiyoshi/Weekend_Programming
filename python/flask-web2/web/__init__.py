from flask import Flask
import os

def create_app():
    app = Flask(__name__)

    UPLOAD_FOLDER = 'F:/Program/Programming_study/python/flask-web2/web/static'
    app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER

    from . import authors #同じフォルダー内にあるauthors.pyを参照
    app.register_blueprint(authors.bp) #bpオブジェクトを登録

    from . import books
    app.register_blueprint(books.bp)

    app.config.from_mapping(
        SECRET_KEY='temp', #暗号化キー（実際はもっと複雑なものを使う）
        DATABASE=os.path.join(app.instance_path, 'bookdb.sqlite3'),
        #instanceフォルダー（既定）に置いたbookdb.sqlite3の相対パス
    )

    #このアプリでデータベースを使えるようにする
    from . import bookdb
    bookdb.init_app(app)

    return app

