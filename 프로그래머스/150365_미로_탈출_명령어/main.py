def solution(n, m, x, y, r, c, k):
    answer = ''

    # impossible
    K = abs(x - r) + abs(y - c)
    if K > k:
        return "impossible"
    else:
        if K % 2 == 0 and k % 2 != 0:
            return "impossible"
        elif K % 2 != 0 and k % 2 == 0:
            return "impossible"

    # greedy + DFS(using stack, not function)
    stack = []

    stack.append((x, y, ''))
    # Down, Left, Right, Up 순으로 greedy 하게 선택
    # 각 방위 별 조건 있음((1x1) ~ (nxm) 범위 내에서만 이동 가능)
    # 가장 처음으로 k만큼 이동하여 (r,c) 에 도착한 경우가 답
    while stack:
        x, y, tail = stack.pop()
        if x == r and y == c and len(tail) == k:
            return tail
        else:
            # 지금의 좌표에서 남은 스텝 (k - len(tail)) 만큼 이동했을때, (r,c) 에 도달할 수 있는지 확인
            if abs(x - r) + abs(y - c) <= k - len(tail):
                if len(tail) < k:
                    if x > 1:
                        stack.append((x - 1, y, tail + 'u'))
                    if y < m:
                        stack.append((x, y + 1, tail + 'r'))
                    if y > 1:
                        stack.append((x, y - 1, tail + 'l'))
                    if x < n:
                        stack.append((x + 1, y, tail + 'd'))


print(solution(3, 3, 1, 2, 3, 3, 4))
print(solution(3, 4, 2, 3, 3, 1, 5))
print(solution(2, 2, 1, 1, 2, 2, 2))
