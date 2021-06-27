# coding: utf-8
"""
５章のチャレンジ問題４
http://tinyurl.com/z54w9cb
"""
def makeDict():
    """
    自分の特徴をまとめた辞書を作成する関数
    身長、好きな色、好きな作家など

    Parameters
    ----------
    None

    Returns
    -------
    retdict : dict
    """
    retdict = dict()
    retdict["height"] = 165
    retdict["color"] = "green"
    retdict["writer"] = "Kyotaro Nishimura"

    return retdict

myCharacteristic = makeDict()

wkkey = input("知りたいキーを入力してください")
if wkkey in myCharacteristic:
    characteristic = myCharacteristic[wkkey]
    print(characteristic)
else:
    print("見つかりません。")

