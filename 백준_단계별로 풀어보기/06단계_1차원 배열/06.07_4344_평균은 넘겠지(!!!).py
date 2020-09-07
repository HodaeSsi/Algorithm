TC = int(input())

answer = []
for i in range(TC):
    lst = list(map(int, input().split(' ')))
    
    sumTotal = sum(lst[1::])
    ave = int(sumTotal/lst[0])

    count = 0
    for j in lst[1::]:
        if j > ave:
            count += 1
    
    answer.append(float(count)/lst[0] * 100)
    
for i in answer:
    print('{0:.3f}%'.format(i))

#뭐냐 소수점 표시 제한 정확히 어떻게 하는거냐