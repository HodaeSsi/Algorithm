N = int(input())

lOper = 0
rOper = 0
result = N
answer = 0

#do while
if result < 10:
    result *= 11
else:
    temp = result // 10
    lOper = result - temp * 10
    result = temp + lOper
    temp = result // 10
    rOper = result - temp * 10
    result = lOper * 10 + rOper
answer += 1
while(result != N):
    if result < 10:
        result *= 11
    else:
        temp = result // 10
        lOper = result - temp * 10
        result = temp + lOper
        temp = result // 10
        rOper = result - temp * 10
        result = lOper * 10 + rOper
    answer += 1

print(answer)