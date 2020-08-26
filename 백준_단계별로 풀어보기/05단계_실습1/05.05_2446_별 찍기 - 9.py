N = int(input())

output = []

#첫 번째 원소 = 1별 + (N-1)*2별
star = '*'
output.append((N-1)*2*star + '*')
for i in range(1, N):
    output.append(i*' ' + output[i-1][i:-1])

for i in output:
    print(i)
for i in output[-2:-1*len(output) -1:-1]:
    print(i)