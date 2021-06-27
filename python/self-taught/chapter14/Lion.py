"""
１４章：特殊メソッド
http://tinyurl.com/ze8yr7s
http://tinyurl.com/j5rocqm

"""
class Lion:
    def __init__(self, name):
        self.name = name
    
    def __repr__(self):
        return self.name

lion = Lion("Dilbert")
print(lion)
