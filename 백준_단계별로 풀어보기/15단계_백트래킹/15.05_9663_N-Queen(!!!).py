def Check(depth: int) -> bool:
    for i in range(depth):
        if board[i] == board[depth] or depth - i == abs(board[depth] - board[i]):
            return False
    return True

def Recur(depth: int):
    #global board
    global result

    if depth == N:
        result += 1
        #return None
    else:
        for i in range(N):
            board[depth] = i
            if Check(depth):
                Recur(depth + 1)

N = int(input())

board = [0 for i in range(N)]
result = 0
Recur(0)
print(result)

#간발의 차로 시간초과 에반데(주석 부분)
#pypy 코테에서 쓸 수 있긴해???