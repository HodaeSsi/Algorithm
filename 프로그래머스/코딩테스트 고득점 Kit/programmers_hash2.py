def solution(phone_book):
    answer = True

    phoneDic = {}
    for i in phone_book:
        temp = ''
        for j in str(i):
            temp += j
            try:
                phoneDic[temp] += 1
            except:
                phoneDic[temp] = 1

    for i in phone_book:
        if phoneDic[i] > 1:
            answer = False
            break

    return answer