"""
１４章チャレンジ問題２：クラス変数
http://tinyurl.com/j9qjnep

"""
class Square:
    # square_list 初期化
    square_list = []

    def __init__(self, s):
        # square_listに追加する
        self.square_list.append(self)
        print(self.square_list)

        self.side = s

    def print(self):

        print("{} by {} by {} by {}".format(self.side, self.side, self.side, self.side))

square1 = Square(29)
square1.print()


