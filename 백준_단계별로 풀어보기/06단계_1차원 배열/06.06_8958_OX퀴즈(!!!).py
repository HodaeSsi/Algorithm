T = int(input())

answer = []
for i in range(T):
    lst = list(input())

    count = 0
    score = 0
    for j in lst:
        if j == 'O':
            count += 1
            score += count
        else:
            count = 0
    answer.append(score)

for i in answer:
    print(i)

#!!! j is '0'하면 백준 컴파일 에러 뜨네???
#is 랑 == 정확한 차이는???