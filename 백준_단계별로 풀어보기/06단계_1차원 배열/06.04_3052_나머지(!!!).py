remain = [0 for i in range(42)]
result = 0

for i in range(10):
    tmp = int(input())
    remain[tmp%42] += 1

for i in remain:
    if i != 0:
        result += 1

print(result)    

###
#딴 코드!!!
###