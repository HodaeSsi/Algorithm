def solution(progresses, speeds):
    answer = []

    progresses = list(progresses)
    speeds = list(speeds)

    while len(progresses) != 0:
        while progresses[0] < 100:
            # for i in progresses: 파이썬은 all ref아니었어? >>> call by value, call by ref 다시!!!
            for i in range(len(progresses)):
                progresses[i] += speeds[i]

        dayNum = 0
        while progresses[0] >= 100:
            progresses.pop(0)
            speeds.pop(0)
            dayNum += 1
            if len(progresses) == 0:
                break
        answer.append(dayNum)


    return answer

