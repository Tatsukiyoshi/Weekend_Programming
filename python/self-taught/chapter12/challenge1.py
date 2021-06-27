"""
１２章のチャレンジ問題１
http://tinyurl.com/gpqe62e

オブジェクト指向プログラミング：りんご
"""
class Apple:
    def __init__(self, w, c, b, s):
        """重さ、色、産地、糖度（sugar content）"""
        self.weight = w
        self.color = c
        self.birth = b
        self.sugar = s

