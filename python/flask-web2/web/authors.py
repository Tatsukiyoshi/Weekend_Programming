"""
著者一覧ページ
"""
from flask import (
    Blueprint, render_template,
    request, redirect, url_for #あとで使う
)
from web.bookdb import get_db
from web.files import save_csv, read_csv

bp = Blueprint('authors', __name__) #このプログラムを__init__.pyに登録するためのオブジェクト

@bp.route('/authors', methods=['GET']) #「 /authors」というアドレスでGET命令

def all():
    """
    著者一覧を表示する
    """
    db = get_db()
    alldata = db.execute('SELECT * FROM authors').fetchall()
    return render_template('authors/all.html', authors=alldata)

@bp.route('/authors/new', methods=['GET', 'POST'])

def new():
    """
    著者情報を登録するページ
    """
    if request.method == 'POST': #入力欄に値を入れて送信したとき
        name = request.form['name']
        bio = request.form['bio']
        db = get_db()
        db.execute(
            "INSERT INTO authors (name, bio) VALUES (?, ?)",
            (name, bio)
        ) #最初の?にnameの値，次の?にbioの値を代入
        db.commit()
        return redirect(url_for('authors.all')) #著者名一覧を表示してデータの追加を確認
    return render_template('authors/new.html') #GET命令のとき。新規入力欄を表示する

@bp.route('/authors/show/<author_id>', methods=['GET']) #GET命令、つまり読み込むだけ
def show(author_id):
    """
    著者情報ページを表示する
    """
    db = get_db()
    author = db.execute('SELECT * FROM authors where id=?', author_id).fetchone()
    return render_template('authors/show.html', author=author)

@bp.route('/authors/delete/<author_id>', methods=['GET'])

def delete(author_id):
    """
    著者情報を削除するページ
    """
    db = get_db()
    db.execute(
        "DELETE from authors where id=?", author_id
    )
    db.commit()
    return redirect(url_for('authors.all')) #一覧に戻って、削除を確認

@bp.route('/authors/edit/<author_id>', methods=['GET', 'POST'])

def edit(author_id):
    """
    著者情報を編集するページ
    """
    db = get_db()
    if request.method == 'POST':
        name = request.form['name']
        bio = request.form['bio']
        db.execute(
        "UPDATE authors SET name=?, bio=? where id=?", 
        (name, bio, author_id)
        )
        db.commit()
        return redirect(url_for('authors.all'))
    
    #最初にGET命令でページを表示するときの処置
    author = db.execute('SELECT * FROM authors where id=?', author_id).fetchone()
    return render_template('authors/edit.html', author=author)

@bp.route('/authors/upload', methods=['GET', 'POST'])
def upload():
    if request.method == 'POST':
        if 'file' in request.files:
            file = request.files['file']
            save_csv(file) #ファイルを保存
            datadict = read_csv(file.filename) #読み込んでディクショナリに
            db = get_db()
            #ディクショナリなので使いやすい
            for data in datadict:
                db.execute(
                    "INSERT INTO authors (name, bio) VALUES (?, ?)", (data['name'], data['bio'])
                )
            db.commit() #複数の命令を一気に実行
        return redirect(url_for('authors.all')) #いずれにしろ一覧に戻る
    #GET命令で最初に表示するとき
    return render_template('authors/upload.html')
