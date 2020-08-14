#숫자 M
#N장의 카드 중 3장
#M을 넘지 않으며 최대한 가까운 합

#장수 N, 숫자 M
#n1, n2, ...
#N은 3이상 100이하
#3중 for문? >> 100^3 = 1000000
#내림차순 정렬 후 탐색(더 짧다) >> !! 틀렸나베 !!

N, M = list(map(int, input().split(' ')))
n = list(map(int, input().split(' ')))
'''
n.sort(reverse=True)
sum = 0
isEnd = False
for i in range(0, len(n)-2):
    for j in range(i+1, len(n)-1):
        for k in range(i+2, len(n)):
            sum = n[i]+n[j]+n[k]
            if sum <= M:
                isEnd = True
                break
        if isEnd is True:
            break
        else:
            sum = -1
    if isEnd is True:
        break
    else :
        sum = -1

print(sum)
'''

candidate = []
for i in range(0, len(n)-2):
    for j in range(i+1, len(n)-1):
        for k in range(i+2, len(n)):
            candidate.append(n[i]+n[j]+n[k])
#candidate.sort(reverse=True) #헐;; 중복발생;;
candidate = list(set(candidate)).sort(reverse=True)
for i in candidate:
    if i <= M:
        print(i)
        break
