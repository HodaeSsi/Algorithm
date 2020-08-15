N = int(input())

output = ''
for i in range(1, N+1):
    for j in range(N-i):
        output += ' '
    for j in range(i):
        output += '*'
    output += '\n'

print(output, end='')
