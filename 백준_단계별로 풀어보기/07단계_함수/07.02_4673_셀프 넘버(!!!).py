lst = [0 for i in range(10001)]

for i in range(1, 10001):
    tmp = list(map(int, str(i)))
    tmp = sum(tmp) + i
    try:
        lst[tmp] += 1
    except:# Exception as e:
        pass

for i in range(1, 10001):
    if lst[i] == 0:
        print(i)

#딴 코드!!!