"""
１２章のチャレンジ問題４
http://tinyurl.com/gpqe62e

オブジェクト指向プログラミング：六角形
"""
class Hexagon:
    """正六角形"""
    def __init__(self, s):
        """一辺の長さはｃｍ"""
        self.side = s
    
    """外周の長さを求める"""
    def calculate_perimeter(self):
        return self.side * 6

hexagon = Hexagon(5)
print(hexagon.calculate_perimeter())
