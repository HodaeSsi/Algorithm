import functools

def comparator(x, y):
    left = int(str(x) + str(y))
    right = int(str(y) + str(x))

    if left > right:
        return -1
    elif left == right:
        return 0
    else:
        return 1

def solution(numbers):
    answer = ''

    numbers.sort(key=functools.cmp_to_key(comparator))
    if numbers[0] == 0:
        answer = "0"
    else:
        for number in numbers:
            answer += str(number)

    return answer