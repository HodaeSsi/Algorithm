def Check(depth: int) -> bool:
    for i in range(depth):
        if slot[depth] == slot[i]:
            return False
    return True

def Recur(depth: int):
    global slot
    global output

    if depth == M:
        temp = ''
        for i in slot[:-1:]:
            temp += (str(i) + ' ')
        temp += str(slot[-1])
        output.append(temp)
        return None

    for i in range(1, N+1):
        slot[depth] = i
        if Check(depth) is True:
            Recur(depth + 1)
    
N, M = map(int, input().split(' '))
slot = [0 for i in range(M)]
output = []
Recur(0)

for i in output:
    print(i)