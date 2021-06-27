"""
１２章
http://tinyurl.com/zcp32pz

オブジェクト指向プログラミング
"""

class Orange:
    def __init__(self, w, c):
        """weight（重さ）はグラム"""
        self.weight = w
        self.color = c
        self.mold = 0
        print("Created!")
    
    def rot(self, days, temp):
        """temp（湿度）は摂氏"""
        self.mold = days * temp

orange = Orange(200, "orange")
print(orange.mold)
orange.rot(10, 37)
print(orange.mold)
