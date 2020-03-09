N, M = map(int, input().split(" "))
n = [int(1)] * N
m = [int(1)] * M

countN = 0
for i in range(N):
    row = list(input()) #str.split()메서드 정리 // split()(no param)은 split(" ")과 같다!(공백(스페이스, 탭, 엔터, ...) 기준 split)
    countM = 0
    for j in row:
        if j == 'X':
            n[countN] = 0
            m[countM] = 0
        countM += 1
    countN += 1

numN = 0
numM = 0
for i in n:
    if i == 1:
        numN += 1
for i in m:
    if i == 1:
        numM += 1

result = max(numN, numM)
print(result)
