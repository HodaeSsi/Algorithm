import sys

N = int(sys.stdin.readline())
LIST = [int(0)] * (2000001)

for i in range(N):
    n = int(sys.stdin.readline())
    LIST[n] = LIST[n] + 1

for i in range(-1000000, 1000001, 1):
    if LIST[i] != 0:
        for j in range(LIST[i]):
            print(i)