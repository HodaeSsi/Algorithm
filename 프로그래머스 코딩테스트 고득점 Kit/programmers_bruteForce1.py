def solution(answers):
    answer = []

    man = [[1, 2, 3, 4, 5],
           [2, 1, 2, 3, 2, 4, 2, 5],
           [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]

    idx = [0, 0, 0]
    ans = [0, 0, 0]

    for e in answers:
        if e == man[0][idx[0]]:
            ans[0] += 1
        if e == man[1][idx[1]]:
            ans[1] += 1
        if e == man[2][idx[2]]:
            ans[2] += 1

        idx[0] += 1
        idx[1] += 1
        idx[2] += 1

        if idx[0] == len(man[0]):
            idx[0] = 0
        if idx[1] == len(man[1]):
            idx[1] = 0
        if idx[2] == len(man[2]):
            idx[2] = 0

    temp = max(ans)
    for i in range(0, len(ans)):
        if temp == ans[i]:
            answer.append(i + 1)

    answer.sort()

    return answer