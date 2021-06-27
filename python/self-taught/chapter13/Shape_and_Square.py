"""
１３章：継承
http://tinyurl.com/zrnqeo3
http://tinyurl.com/j8lj35s

"""
class Shape:
    def __init__(self, w, l):
        self.width = w
        self.len = l

    def print_size(self):
        print("{} by {}".format(self.width, self.len))

class Square(Shape):
    pass

# my_shape = Shape(20, 25)
# my_shape.print_size()
a_square = Square(20, 20)
a_square.print_size()
