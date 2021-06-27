"""
１４章チャレンジ問題３：オブジェクトの比較を行う関数
http://tinyurl.com/j9qjnep

"""

def chk2Object(obj1, obj2):
    if(obj1 is obj2):
        return True
    else:
        return False

a = "xyz"
b = a
c = "abc"

print(chk2Object(a, b))
print(chk2Object(a, c))
