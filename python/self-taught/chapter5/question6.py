# coding: utf-8
"""
５章のチャレンジ問題６
http://tinyurl.com/z54w9cb

PythonのSetについて、調べよう
https://qiita.com/yossyyossy/items/ddc285ad90c305e21eda
"""

# setを用いたデータの作り方
# リストを引数にする場合
x = set([1, 2, 3])
print(x)
# {1, 2, 3}

# タプルを引数にする場合
x_ = set((1, 2, 3))
print(x_)
# {1, 2, 3}

# 波括弧で囲った値を変数に代入する方法
a = {1, 2, 3}
print(a)
# {1, 2, 3}

# setなんてデータ型があるのかを確認する
# 先ほど作成したx,x_という変数を使います！

print(type(x))
# <class 'set'>

print(type(x_))
# <class 'set'>

print(type(a))
# <class 'set'>

# 本当に重複がないかを調べてみる
y = set([1,2,2,3,3,3,4,4,4,4])

print(y)
# {1, 2, 3, 4}

# リスト関数に渡して、indexを指定!
y = list(y)

print(y[1])
# ->2

# リスト内包表記でリストに直して、indexを指定！
print([i for i in y][1])
# ->2
