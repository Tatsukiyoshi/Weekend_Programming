# coding: utf-8
"""
７章のチャレンジ問題５
http://tinyurl.com/z2m2ll5

二つのリストの掛け合わせ
"""

# 入力リスト
List1 = [8, 19, 148, 4]
List2 = [9, 1, 33, 83]

# 掛け合わせリスト
List3 = []

# 入力する値を順番にリストから取り出す
for x in List1:
    for y in List2:
        answer = x * y

        # 掛け合わせた結果をリストに追加する
        List3.append(answer)

        # 掛け合わせた結果を出力する
        output = "{} * {} = {}".format(x, y, answer)
        print(output)

# 掛け合わせた結果を最後に出力して確認する
print(List3)
