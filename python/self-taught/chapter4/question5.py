# coding: utf-8
"""
４章のチャレンジ問題５
４章のチャレンジ問題６
http://tinyurl.com/hkzgqrv
"""
def toFloat(pstr):
    """
    引数で受け取った文字列をfloat型に変換する

    Parameters
    ----------
    pstr : string
        受け取る文字列。

    Returns
    -------
    retval : float
        引数で受け取った文字列をfloat型に変換した値

    """
    try:
        return float(pstr)
    except ValueError as Exo:
        print("Exception[", Exo, "]:", pstr)

wkstr = input("文字列を入力してください")

fval = toFloat(wkstr)
print("Float Value=", fval)
