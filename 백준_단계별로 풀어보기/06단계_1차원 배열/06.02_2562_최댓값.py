count = 0
tempCount = 0
result = 0
for i in range(9):
    tmp = int(input())
    tempCount += 1
    if tmp > result:
        result = tmp
        count = tempCount
    
print(result)
print(count)