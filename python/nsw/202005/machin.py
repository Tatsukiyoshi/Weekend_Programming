# マチンの公式による円周率の近似値の計算

s1 = 16 * sum(((-1)**n / (2*n+1)) * (1/5)**(2*n+1) for n in range(11))
s2 = 4 * sum(((-1)**n / (2*n+1)) * (1/239)**(2*n+1) for n in range(11))
print(s1 - s2)
