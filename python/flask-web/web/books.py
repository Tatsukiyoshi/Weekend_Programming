# Webページ記述プログラム

# Blueprintクラスとrender_templateメソッドをインポート
from flask import (
    Blueprint, render_template
)

# Blueprintオブジェクトを作成
# booksは、books.pyを指し、
# __name__は__init__.pyの関数create_appに渡す
bp = Blueprint('books', __name__)
# Blueprintオブジェクトを用いて、デコレータを記述
@bp.route('/')

def index():
    # 引数で指定したHTMLファイルの内容を表示する       
    return render_template('index.html', books=get_testdata())

def get_testdata():
    return [
        {'id':1, 'title':'プリンキピア', 'author':'ニュートン', 'genre':'物理' },
        {'id':2, 'title':'化学原論', 'author':'ラボアジェ', 'genre':'化学' },
        {'id':3, 'title':'整数論', 'author':'ガウス', 'genre':'数学' },
        {'id':4, 'title':'天体の回転について', 'author':'コペルニクス', 'genre':'物理'},
        {'id':5, 'title':'熱の解析的理論', 'author':'フーリエ', 'genre':'数学'},
        {'id':6, 'title':'発薇算法', 'author':'関孝和', 'genre':'数学'},
    ]
    