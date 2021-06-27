"""
１２章のチャレンジ問題３
http://tinyurl.com/gpqe62e

オブジェクト指向プログラミング：三角形
"""
class Triangle:
    def __init__(self, b, h):
        """底辺、高さはどちらもｃｍ"""
        self.base = b
        self.height = h
    
    """面積を求める（面積＝底辺×高さ÷２）"""
    def area(self):
        return self.base * self.height / 2

triangle = Triangle(5, 5)
print(triangle.area())
