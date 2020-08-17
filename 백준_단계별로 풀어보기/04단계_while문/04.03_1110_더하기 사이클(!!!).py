N = int(input())

newNum = -1
count = 0
newNum = N
while(newNum != N or count == 0):
    if newNum < 10:
        newNum *= 2
    else:
        tmp = str(newNum)
        newNum = int(tmp[0]) + int(tmp[1])
        if newNum < 10:
            newNum = int(tmp[1] + str(newNum))
        else:
            newNum = int(tmp[1] + str(newNum)[1])
        
    count += 1

print(count)

#아직 안품;;