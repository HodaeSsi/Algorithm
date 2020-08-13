'''def fibo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibo(n-1) + fibo(n-2)

n = int(input())
print(fibo(n))'''
#n = 45에도 시간초과(1초);;

n = int(input())

num1 = 0
num2 = 1
for i in range(2, n+1):
    if i%2 == 0:
        #짝수면
        num1 = num1 + num2
    else:
        #홀수면
        num2 = num1 + num2

if n%2 == 0:
    print(num1)
else:
    print(num2)