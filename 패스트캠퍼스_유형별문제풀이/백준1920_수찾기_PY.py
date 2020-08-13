N = int(input())
n = set(map(int, input().split(' ')))
M = int(input())
m = list(map(int, input().split(' ')))

for i in m:
    if i in n:
        print(1)
    elif i not in n:
        print(0)