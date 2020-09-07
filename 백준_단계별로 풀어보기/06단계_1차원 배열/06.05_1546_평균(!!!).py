N = int(input())
scoreList = list(map(int, input().split(' ')))
maximum = max(scoreList)

sum = 0
for i in range(len(scoreList)):
    scoreList[i] = float(scoreList[i])/maximum * 100
    sum += scoreList[i]

print(sum/len(scoreList))

# 점수/최대값 * 100 에 무슨 '수'적 의미가 있을것 같은데 ???