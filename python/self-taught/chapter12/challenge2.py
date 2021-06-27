"""
１２章のチャレンジ問題２
http://tinyurl.com/gpqe62e

オブジェクト指向プログラミング：円
"""

import math

class Circle:
    def __init__(self, r):
        """半径はｃｍ"""
        self.radius = r
    
    """面積を求める（円周率π*半径の２乗）"""
    def area(self):
        return math.pi * self.radius * self.radius

circle = Circle(5)
print(circle.area())
