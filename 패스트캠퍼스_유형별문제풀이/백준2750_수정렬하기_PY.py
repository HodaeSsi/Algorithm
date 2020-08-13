N = int(input())

result = []
for i in range(N):
    n = int(input())
    result.append(n)
    result.sort()
for i in result:
    print(i)