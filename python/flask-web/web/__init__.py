# Flaskオブジェクトのインポート
from flask import Flask

# 関数creat_app
def create_app():
    app = Flask(__name__)

    # 同じフォルダのbooks.pyをインポートする
    from . import books

    # appの構成要素にbooks.pyで定義したオブジェクトbpを登録する
    app.register_blueprint(books.bp)

    @app.route('/test')
    def apptest():
        return 'アプリケーションセットアップ完了！'

    return app
