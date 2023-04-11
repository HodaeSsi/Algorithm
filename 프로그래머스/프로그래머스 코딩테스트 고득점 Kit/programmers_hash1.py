def solution(participant, completion):
    answer = ''

    scoreDict = {}
    for i in completion:
        try:
            scoreDict[i] += 1
        except KeyError as e:
            scoreDict[i] = 1

    for i in participant:
        try:
            scoreDict[i] -= 1
            if scoreDict[i] == -1:
                answer = i
        except KeyError as e:
            answer = i

    return answer