# coding: utf-8
"""
４章のチャレンジ問題３
４章のチャレンジ問題６
http://tinyurl.com/hkzgqrv
"""
def optional_func(p1, p2, p3, p4=0, p5=1):
    """
    ３つの必須引数と２つのオプション引数を取る関数

    Parameters
    ----------
    p1 : int
    p2 : int
    p3 : int
    p4 : int
    p5 : int
    """
    print(p1, p2, p3, p4, p5)

optional_func(1, 2, 3)
optional_func(1, 2, 3, 4, 5)
