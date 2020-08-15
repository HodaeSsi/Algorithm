T = int(input())

output = ''
for i in range(1, T+1):
    A, B = map(int, input().split(' '))
    output = output + 'Case #{}: {}'.format(i, (A+B)) + '\n'

print(output, end='')