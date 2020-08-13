A, B, C = map(int, input().split(' '))
print((A+B)%C)
print(((A%C)+(B%C))%C)
print((A*B)%C)
print(((A%C)*(B%C))%C)

#나머지 연산자에 대한 분배법칙 정리?