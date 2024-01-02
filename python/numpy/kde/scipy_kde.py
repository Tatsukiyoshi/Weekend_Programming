# scipyモジュールをインポート
import numpy as np
import scipy.stats as stats
import matplotlib.pyplot as plt

# データのサンプル（正規分布から生成）
data = [0.5, 1.2, 1.8, 2.3, 2.7, 3.1]

# ガウスカーネルを用いたKDEを実行
kde = stats.gaussian_kde(data, bw_method=0.5)

# x軸の値の範囲
x = np.linspace(0, 4, 100)

# x軸の値に対応する確率密度を計算
y = kde(x)

# 結果をプロット
plt.plot(x, y)
plt.show()
