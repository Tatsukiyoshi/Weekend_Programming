# coding: utf-8
"""
５章のチャレンジ問題２
http://tinyurl.com/z54w9cb
"""
def makeBeenList():
    """
    行ったことがある場所のリストを作成する関数
    行ったことがある場所は、緯度・経度をタプルで持つ

    Parameters
    ----------
    None

    Returns
    -------
    retlst : list
    """
    retlst = []
    retlst.append(("Frankfurt", 50.110922, 8.682127))           # フランクフルト
    retlst.append(("Paris", 48.856614, 2.352222))               # パリ
    retlst.append(("Seattle", 47.60621, -122.332071))           # シアトル
    retlst.append(("Sapporo", 43.061771, 141.354451))           # 札幌
    retlst.append(("Lake Towada", 40.464869, 140.877243))       # 十和田湖
    retlst.append(("Beijing", 39.9042, 116.407396))             # 北京
    retlst.append(("Sendai", 38.268195, 140.869418))            # 仙台
    retlst.append(("Iwaki", 37.050506, 140.887744))             # いわき
    retlst.append(("Nikkou", 36.719899, 139.698236))            # 日光
    retlst.append(("Amanohashidate", 35.569802, 135.19182))     # 天橋立
    retlst.append(("Tottori Sakyu", 35.540723, 134.229071))     # 鳥取砂丘
    retlst.append(("Mt.Fuji", 35.360626, 138.727363))           # 富士山
    retlst.append(("Kamogawa Sea World", 35.115895, 140.120323))# 鴨川シーワールド
    retlst.append(("Abeno Harukasu", 34.645842, 135.513971))    # あべのハルカス
    retlst.append(("Kurashiki", 34.584978, 133.771981))         # 倉敷
    retlst.append(("Hiroshima", 34.385289, 132.455306))         # 広島
    retlst.append(("Sanuki Children's Country", 34.211954, 134.01676))            # さぬきこどもの国

    return retlst

beenlist = makeBeenList()
print(beenlist)
