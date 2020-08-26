N = int(input())

pattern = ['*', '']
if N == 1:
    print(pattern[0])
else:
    for i in range(N-1):
        if i % 2 == 0:
            pattern[1] = pattern[1] + ' *'
        else:
            pattern[0] = pattern[0] + ' *'
    
    for i in range(N):
        for j in pattern:
            print(j)

