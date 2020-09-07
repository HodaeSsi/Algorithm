alphabet = list('abcdefghijklmnopqrstuvwxyz')
idxList = [-1 for i in range(26)]

S = list(input())
wordIdx = 0
for i in S:
    alphabetIdx = 0
    for j in alphabet:
        if i == j and idxList[alphabetIdx] == -1:
            idxList[alphabetIdx] = wordIdx

        alphabetIdx += 1
    wordIdx += 1  

output = ''
for i in idxList[:-1:]:
    output += '{} '.format(i)
print(output + str(idxList[-1]))

#딴 코드!!!