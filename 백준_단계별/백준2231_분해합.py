#2초
#자연수 N
#N의 분해합 = N + N을 이루는 각 자리수의 합(ex_245 >> 245 + 2 + 4 + 5 = 256)
#생성자 M(N이 M의 분해합인 경우)

N = int(input()) #1이상 백만이하
#내가 찾는 M = 분해합으로 N을 만들수 있는 수
#M = M + a >> M <= N
M = []
for i in range(N+1):
    temp1 = i
    temp2 = list(map(int, str(i)))
    tempSum = 0
    for j in temp2:
        tempSum += j
    if temp1 + tempSum == N:
        M.append(i)
    
if len(M) == 0:
    print(0)
else:
    print(M[0])

