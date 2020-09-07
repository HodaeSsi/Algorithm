N = int(input())

if N <= 99:
    print(N)
else:
    answer = 99
    for i in range(100, N+1):
        lst = list(map(int, str(i)))
        tmp1 = lst[0] - lst[1]
        isHanSu = True
        for j in range(1, len(lst)-1):
            tmp2 = lst[j] - lst[j+1]
            if tmp1 != tmp2:
                isHanSu = False
                break
            tmp1 = tmp2
        if isHanSu is True:
            answer += 1

    print(answer)

#딴 코드!!!


            
