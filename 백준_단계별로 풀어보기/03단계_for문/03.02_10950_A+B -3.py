T = int(input())

tmp = []
for i in range(T):
    tmp.append(tuple(map(int, input().split(' '))))

for i in tmp:
    print(i[0] + i[1])