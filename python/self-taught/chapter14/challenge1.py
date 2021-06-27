"""
１４章チャレンジ問題１：クラス変数
http://tinyurl.com/j9qjnep

"""
class Square:
    # square_list 初期化
    square_list = []

    def __init__(self):
        # square_listに追加する
        self.square_list.append(self)
    
square1 = Square()
square2 = Square()

print(Square.square_list)

