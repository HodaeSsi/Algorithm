N = int(input())

result = []
for i in range(N):
    temp = list(input().split(' '))
    temp[0] = int(temp[0])
    info = temp
    info.append(int(i))
    result.append(info)

result.sort(key=lambda x : (x[0], x[2])) #야 이거 이해 안된다(람다 x랑 다중 조건 원리 자체도)
#sort이거 문자열끼리 비교하면 무슨 기준이냐(len?)
for i in result:
    print(str(i[0]) + " " + i[1])
    
#https://wayhome25.github.io/python/2017/03/07/key-function/
#list.sort() 특정 기준으로 정렬하기(key)
#https://dailyheumsi.tistory.com/67
#list.sort() 다중 조건으로 정렬하기(복잡한 key)