# ネイピア数

def factorial(n):
  k = 1
  for i in range(1, n + 1): k = k * i
  return k

e = sum(1/factorial(n) for n in range(18))

print(e)
