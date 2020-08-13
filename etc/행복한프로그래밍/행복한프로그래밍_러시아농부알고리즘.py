def multiply(n, m):
    return n * m

n, m = list(map(int, input().split(' ')))

tempList = []
while(True):
    if(n % 2 != 0):
        tempList.append(m)
        if n == 1:
            break

    n //= 2
    m *= 2
    
sum = 0
for i in tempList:
    sum += i

print(sum)