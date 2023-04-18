def isPrime(num):
    i = 2
    if num == 1:
        return False
    if num == 2:
        return True
    while True:
        if num % i == 0:
            return False
        i += 1
        if i * i > num:
            break

    return True


def permu(canList, r, string):
    global result, visits

    if len(string) >= r:
        if isPrime(int(string)):
            result.add(string)
        return

    for i in range(len(canList)):
        if len(string) == 0 and canList[i] == '0':
            continue
        if not visits[i]:
            string += str(canList[i])
            visits[i] = True
            permu(canList, r, string)
            visits[i] = False
            string = string[0:len(string) - 1]


result = set()
visits = []


def solution(numbers):
    global visits

    visits = [False for i in range(len(numbers))]

    canList = list(numbers)
    for i in range(1, len(numbers) + 1):
        permu(canList, i, "")

    answer = len(result)

    return answer
