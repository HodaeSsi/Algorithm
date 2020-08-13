T = int(input())
Output = []
for i in range(T):
    N, M = list(map(int, input().split(' ')))
    #[N, M] 으로 표현 가능 >> Arr = [N, M] = ... 도 가능
    n = list(map(int, input().split(' ')))
    orderList = [0 for j in range(10)]
    for j in n:
        orderList[j] = orderList[j] + 1
        
    result = 0
    #시뮬레이팅
    #테스트
    '''howmany = 0
    for j in n:
        if j == 4:
            n.append(5)
        if j == 5:
            print('im here')
        howmany = howmany + 1
    print(howmany)'''
    #0. 지금 가장 높은 우선순위는?(타겟 우선순위)
    targetOrder = int()
    cycle = 0
    for j in range(9, 0, -1):
        if orderList[j] != 0:
            targetOrder = j
            break
    for j in n:
    #1. 가장 높은 우선순위 인가
        #1.1 그렇다
        if j == targetOrder:
        #1.1.1 삭제
            result = result + 1
            #1.1.2 M인가
            if cycle == M:
                break
            else:
                #1.1.2 타겟 우선순위 갱신
                orderList[targetOrder] = orderList[targetOrder] - 1
                for k in range(9, 0, -1):
                    if orderList[k] != 0:
                        targetOrder = k
                        break
        #1.2 아니다
        else:
        #1.2.1 뒤로보낸다
            n.append(j)
            if cycle == M:
                M = len(n) - 1
        cycle = cycle + 1
    Output.append(result)

for i in Output:
    print(i)
#map(lambda x: print(x), Output)
