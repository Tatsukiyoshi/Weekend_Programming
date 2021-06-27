"""
書籍一覧ページ
"""
from flask import (
    Blueprint, render_template,
    request, redirect, url_for
)
from web.bookdb import get_db
from web.files import save_img, write_file

bp = Blueprint('books', __name__) #authorsから書き換える

@bp.route('/books', methods=['GET'])

def all():
    """
    書籍一覧を表示する
    """
    db = get_db()
    alldata = db.execute('SELECT * FROM books').fetchall()
    return render_template('books/all.html', books=alldata)

@bp.route('/books/new', methods=['GET', 'POST'])

def new():
    """
    書籍情報を登録するページ
    """
    db = get_db() #GETでもPOSTでもデータベースを使う
    if request.method == 'POST':
        title = request.form['title']
        author = request.form['author']
        db.execute(
            "INSERT INTO books (title, author) VALUES (?, ?)",
            (title, author) #coverは初期値を用いる
        )
        db.commit()
        return redirect(url_for('books.all'))
    authors = db.execute('SELECT * FROM authors').fetchall()
    return render_template('books/new.html', authors=authors)

@bp.route('/books/show/<book_id>', methods=['GET'])
def show(book_id):
    """
    書籍情報ページを表示する
    """
    db = get_db()
    book = db.execute('SELECT * FROM books where id=?', book_id).fetchone()
    return render_template('books/show.html', book=book)

@bp.route('/books/upload/<book_id>', methods=['GET', 'POST'])
def upload(book_id):
    db = get_db()
    if request.method == 'POST':
        if 'file' in request.files: #リクエストにファイル情報が含まれていたら
            file = request.files['file']
            save_img(file) #files.pyで定義したメソッド
            db.execute( #booksテーブルでのファイル名を初期値から固有値に変更
            "UPDATE books SET cover=? where id=?",
            (file.filename, book_id)
            )
            db.commit()

        #更新の成否にかかわらず、詳細ページへ送る
        return redirect(url_for('books.show', book_id=book_id) )

    #GETで読み込まれたとき
    book = db.execute('SELECT * FROM books where id=?', book_id).fetchone()
    return render_template('books/upload.html', book=book)

@bp.route('/books/write', methods=['GET']) #GET命令で表示するのみ
def write():
    csv_str = "" #CSVの長い文字列。最初は空にしておく。
    db = get_db()
    alldata = db.execute('SELECT * FROM books').fetchall()
    for data in alldata:
        csv_str += ",".join([data['title'], data['author'], data['cover']])
        # カンマでつなげる。Pythonのjoinメソッドは、デリミタ文字列が呼び出す
        csv_str += "\n" #1行分をつなげたところで改行
    write_file("books.csv", csv_str) #ファイルに書き出す
    return render_template('books/write.html', str=csv_str) #テキストエリアに表示するために渡す
