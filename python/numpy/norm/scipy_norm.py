# randomモジュールとscipyモジュールをインポート
import random
import scipy.stats as stats

# 乱数の個数
N = 1000

# 乱数の範囲
a = 0
b = 10

# 乱数のリストを作成
random_list = [random.uniform(a, b) for _ in range(N)]

# 乱数のリストを母集団とする正規分布オブジェクトを作成
norm = stats.norm.fit(random_list)

# 正規分布オブジェクトの平均と標準偏差を取得
mu = norm[0]
sigma = norm[1]

# 任意のx値
x = 5

# x値に対応する確率密度を計算
pdf = stats.norm.pdf(x, mu, sigma)

# 結果を表示
print(f"乱数の平均: {mu:.2f}")
print(f"乱数の標準偏差: {sigma:.2f}")
print(f"x = {x} のときの確率密度: {pdf:.4f}")
