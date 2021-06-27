"""
１３章チャレンジ問題４：コンポジション
http://tinyurl.com/hz9qdh3

"""
# 騎手
class Rider:
    def __init__(self, n):
        self._name = n

    def showName(self):
        return self._name

# 馬
class Horse:
    def __init__(self, n, r):
        self._name = n
        self._rider = r
    
    def showName(self):
        return self._name

    def showRider(self):
        return self._rider

okabeYukio = Rider("岡部幸雄")
symboliRudolf = Horse("Symboli Rudolf", okabeYukio)

print(symboliRudolf.showName())
print(symboliRudolf.showRider().showName())
