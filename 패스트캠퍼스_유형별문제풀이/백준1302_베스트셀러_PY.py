import sys

N = int(input())
bookDict = {}
for i in range(N):
    novel = input()
    #novel = sys.stdin.readline() #이거 문자열뒤에 \n남네??? + 문자열 관련 메서드
    try:
        bookDict[novel] += 1
    except KeyError as e:
        bookDict[novel] = 1
    
dictKey = list(bookDict.keys()) #이거 반환형 dict_keys객체네??? >> dict문법 이해 부족
bookList = []
for i in dictKey:
    bookList.append([i, bookDict[i]])

bookList.sort(key=lambda x: (x[1]), reverse=True)
lalala = bookList[0][1]
answerList = []
answerList.append(bookList[0])
for i in bookList[1:len(bookList):1]:
    if i[1] == lalala:
        answerList.append(i)
    else:
        break

answerList.sort(key=lambda x: (x[0]))
print(answerList[0][0])

'''
for i in dictKey[1: len(dictKey): 1]:
    print(i)
    print(bestSellerList)
    if i == bestSellerList[0]:

    else:
        if bookDict[i] == bookDict[bestSellerList[0]]:
            bestSellerList.append(i)
        elif bookDict[i] >= bookDict[bestSellerList[0]]:
            bestSellerList.clear()
            bestSellerList.append(i)

bestSellerList.sort()
for i in bestSellerList:
    print(i)
    #print(i, end="") #이거 원리가 뭐라고? >> 출력초과???'''
