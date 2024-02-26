dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def bfs(graph, visited, start_node, result_array) -> None:
    chunk_size = 0
    col_set = set()

    q = [start_node]
    visited[start_node[0]][start_node[1]] = True
    chunk_size += 1
    col_set.add(start_node[1])
    while q:
        now = q.pop()

        for i in range(4):
            next_y = now[0] + dy[i]
            next_x = now[1] + dx[i]
            if 0 <= next_y < len(graph) and 0 <= next_x < len(graph[0]):
                if graph[next_y][next_x] == 1 and not visited[next_y][next_x]:
                    q.append((next_y, next_x))
                    visited[next_y][next_x] = True
                    chunk_size += 1
                    col_set.add(next_x)

    for i in col_set:
        result_array[i] += chunk_size


def solution(land):
    col = [0 for _ in range(len(land[0]))]
    visited = [[False for _ in range(len(land[0]))] for _ in range(len(land))]

    for i in range(len(land)):
        for j in range(len(land[0])):
            if land[i][j] == 1 and not visited[i][j]:
                bfs(land, visited, (i, j), col)

    return max(col)


print(solution([[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]))
