N, X = map(int, input().split(' '))
A = list(map(int, input().split(' ')))

output = ''
for i in A:
    if i < X:
        output += '{} '.format(i)

print(output.rstrip())