import random
import matplotlib.pyplot as plt

N = 100000
c = 0
ix = []
iy = []
ox = []
oy = []

for i in range(N):
  x = random.uniform(-1, 1)
  y = random.uniform(-1, 1)
  if x*x + y*y <= 1:
    c = c + 1
    ix.append(x)
    iy.append(y)
  else:
    ox.append(x)
    oy.append(y)

plt.scatter(ix, iy,color='b',marker='.')
plt.scatter(ox, oy,color='r',marker='.')
plt.axis([-1, 1, -1, 1])
plt.axes().set_aspect('equal')
plt.show()

P = c / N
print(4 * P)
