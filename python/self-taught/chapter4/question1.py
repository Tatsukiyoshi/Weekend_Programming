# coding: utf-8
"""
４章のチャレンジ問題１
４章のチャレンジ問題６
http://tinyurl.com/hkzgqrv
"""
def square(num):
    """
    数字の２乗を返す関数

    Parameters
    ----------
    num : int
        ２乗を求める整数。

    Returns
    -------
    retval : int
        ２乗の値。
    """
    retval = num * num

    return retval

value = int(input("値を入力してください"))
print("その値の２乗は、", square(value))
