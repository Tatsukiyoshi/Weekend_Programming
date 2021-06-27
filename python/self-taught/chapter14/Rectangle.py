"""
１４章：クラス変数とインスタンス変数
http://tinyurl.com/zmnf47e

"""
class Rectangle:
    def __init__(self, w, l):
        self.width = w
        self.len = l

    def print_size(self):
        print("{} by {}".format(self.width, self.len))

my_rectangle = Rectangle(10, 24)
my_rectangle.print_size()
