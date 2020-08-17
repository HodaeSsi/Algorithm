A, B = -1, -1

output = ''
while True:
    A, B = map(int, input().split(' '))
    if A == 0 and B == 0:
        break
    output = output + '{}'.format(A+B) + '\n'

print(output, end='')
#남코드!!!!!