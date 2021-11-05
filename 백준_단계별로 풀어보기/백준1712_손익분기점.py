#600~800만번 연산
#A B C (21억 이하)
#x * C = A + x * B
#x(C - B) = A
#x = A / (C - B)

A, B, C = list(map(int, input().split(' ')))

if C <= B:
    print(-1)
else:
    print(int(A / (C - B) + 1))