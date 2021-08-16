N = int(input())

result = []
for i in range(N):
    xy = list(map(int, input().split(" ")))
    result.append(xy)

result.sort(key=lambda x: (x[0], x[1]))
for i in result:
    print(str(i[0]) + " " + str(i[1]))