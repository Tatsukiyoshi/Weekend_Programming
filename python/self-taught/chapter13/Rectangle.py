"""
１３章：カプセル化
# http://tinyurl.com/j74o5rh

"""
class Rectangle:
    def __init__(self, w, l):
        self.width = w
        self.len = l

    def area(self):
        return self.width * self.len
