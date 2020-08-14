n = int(input())
m = list(map(int, input()))
m.reverse()

sum = 0
count = 1
for i in m:
    tmp = n * i
    sum += tmp * count
    print(tmp)
    count *= 10
print(sum)