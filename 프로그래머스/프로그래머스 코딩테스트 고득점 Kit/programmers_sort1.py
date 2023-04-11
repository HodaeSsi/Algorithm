def solution(array, commands):
    answer = []

    for command in commands:
        tempList = list(array)
        tempList = tempList[command[0]-1:command[1]]
        tempList.sort()
        answer.append(tempList[command[2]-1])

    return answer