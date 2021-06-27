# coding: utf-8
"""
６章のチャレンジ問題２
http://tinyurl.com/hapm4dx

２つ文字列を入力し、それらの文字列を別の文字列に穴埋めし、新しい文字列を作る
"""

str1 = input("文字列１を入力してください->")
str2 = input("文字列２を入力してください->")

newstr = "私は昨日{}を書いて、{}に送った".format(str1, str2)
print(newstr)
