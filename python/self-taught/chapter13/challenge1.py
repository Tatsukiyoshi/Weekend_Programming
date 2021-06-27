"""
１３章チャレンジ問題１：外周の長さ
http://tinyurl.com/hz9qdh3

"""
class Rectangle():
    def __init__(self, w, l):
        self.width = w
        self.len = l

    def calculate_perimeter():
        return (width + len) * 2

class Square():
    def __init__(self, s):
        self.side = s

    def calculate_perimeter():
        return side * 4

shape1 = Rectangle(20, 25)
shape2 = Square(25)

print(shape1.calculate_perimeter())
print(shape2.calculate_perimeter())
