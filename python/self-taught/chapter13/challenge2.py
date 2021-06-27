"""
１３章チャレンジ問題２：一辺の長さの変更
http://tinyurl.com/hz9qdh3

"""
# 長方形
class Rectangle():
    # 初期化
    def __init__(self, w, l):
        self.width = w
        self.len = l

    # 全周を返す
    def calculate_perimeter(self):
        return (self.width + self.len) * 2

# 正方形
class Square():
    # 初期化
    def __init__(self, s):
        self.side = s

    # 全周を返す
    def calculate_perimeter(self):
        return self.side * 4

    # 一辺の長さを変える（増やす場合には、正の整数を、減らす場合には、負の整数を渡す）
    def change_size(self, w):
        self.side = self.side + w

# 縦20cm横25cmの長方形
shape1 = Rectangle(20, 25)
print(shape1.calculate_perimeter())

# 一辺25cmの正方形
shape2 = Square(25)
print(shape2.calculate_perimeter())

# 正方形の横幅を5cm増やす
shape2.change_size(5)
print(shape2.calculate_perimeter())

# 正方形の横幅を8cm減らす
shape2.change_size(-8)
print(shape2.calculate_perimeter())
