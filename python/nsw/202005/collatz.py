# コラッツ予想
import sys

n = int(sys.argv[1])

while n != 1:
  n = n / 2 if n % 2 == 0 else n * 3 + 1
  print(int(n), end=" ")

