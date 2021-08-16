birdNum = int(input())

N = 1
answer = 0
while birdNum > 0:
    if N > birdNum:
        N = 1
    else:
        birdNum -= N
        N += 1
        answer += 1

print(answer)