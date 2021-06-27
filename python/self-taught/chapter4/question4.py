# coding: utf-8
"""
４章のチャレンジ問題４
４章のチャレンジ問題６
http://tinyurl.com/hkzgqrv
"""
def func1(p1):
    """
    引数で受け取った整数を２で割って求められる整数を返す

    Parameters
    ----------
    p1 : int
        受け取る整数。

    Returns
    -------
    retval : int
        引数で受け取った整数を２で割って求められる整数

    """
    retval = int(p1 / 2)

    return retval

def func2(p2):
    """
    引数で受け取った整数の４倍を返す

    Parameters
    ----------
    p1 : int
        受け取る整数。

    Returns
    -------
    retval : int
        引数で受け取った整数の４倍となる整数
    """
    retval = p2 * 4
    return retval

wkinp = int(input("整数を入力してください"))
wkval = func1(wkinp)
print("１つ目の関数の結果：", wkval)
wkval2 = func2(wkval)
print("２つ目の関数の結果：", wkval2)
