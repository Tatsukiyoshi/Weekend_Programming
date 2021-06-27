"""
１３章チャレンジ問題３：継承とデータ型表示
http://tinyurl.com/hz9qdh3

"""
# 図形
class Shape():
    def __init__(self, n):
        self.name = n

    def what_am_i(self):
        print("I am a {}".format(self.name))

# 長方形
class Rectangle(Shape):
    # 初期化
    def __init__(self, n, w, l):
        super().__init__(n)
        self.width = w
        self.len = l

    # 全周を返す
    def calculate_perimeter(self):
        return (self.width + self.len) * 2

# 正方形
class Square(Shape):
    # 初期化
    def __init__(self, n, s):
        super().__init__(n)
        self.side = s

    # 全周を返す
    def calculate_perimeter(self):
        return self.side * 4

    # 一辺の長さを変える（増やす場合には、正の整数を、減らす場合には、負の整数を渡す）
    def change_size(self, w):
        self.side = self.side + w

# 縦20cm横25cmの長方形
shape1 = Rectangle("rectangle", 20, 25)
shape1.what_am_i()

# 一辺25cmの正方形
shape2 = Square("square", 25)
shape2.what_am_i()
