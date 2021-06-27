# coding: utf-8
"""
９章のチャレンジ問題２
http://tinyurl.com/hll6t3q

質問への回答をファイルに書き出す
"""

ans = input("名前は？")
with open("result.txt", "w", encoding="utf-8") as f:
    f.write(ans)

