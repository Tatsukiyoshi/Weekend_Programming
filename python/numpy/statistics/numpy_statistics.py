#ライブラリのインポート
import numpy as np

#numpyを使わない配列
list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] 
#numpy配列
nplist = np.array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])

print(list)
print(nplist)

###
#numpy配列
nplist = np.array([82, 94, 93, 89, 91, 84, 98, 79])

#最大値
big = np.max(nplist)
print("最大値",big)

#最小値
small = np.min(nplist)
print("最小値",small)

#中央値
middle = np.median(nplist)
print("中央値",middle)

#numpy.mean(): 配列の要素の平均値を算出
a = np.mean(nplist)
print("平均値",a)

#分散の算出
nplist_var = np.var(nplist)
print("分散", nplist_var)

#標準偏差の算出
nplist_std = np.std(nplist)
print("標準偏差", nplist_std)
