"""
１３章：カプセル化
http://tinyurl.com/jkaorle

"""
class PublicPrivateExample:
    def __init__(self):
        self.public = "safe"
        self._unsafe = "unsafe"
    
    def public_method(self):
        # clientが使っても良い
        pass # pass文は、文が必須な構文で何もしない場合に使う（nop）

    def _unsafe_method(self):
        # clientは使うべきじゃない
        pass # pass文は、文が必須な構文で何もしない場合に使う（nop）

data1 = PublicPrivateExample()
# パブリック（clientが参照できる変数、メソッド）
print(data1.public)
data1.public_method()
# プライベート（clientが参照してはいけない変数、メソッド）
print(data1._unsafe)
data1._unsafe_method()
