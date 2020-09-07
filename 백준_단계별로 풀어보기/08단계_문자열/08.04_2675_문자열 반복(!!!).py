T = int(input())

output = ''
for i in range(T):
    R, S = list(input().split(' '))
    S = list(S)
    
    for j in S:
        for k in range(int(R)):
            output += j

    output += '\n'

print(output, end='')

#딴 코드!!!