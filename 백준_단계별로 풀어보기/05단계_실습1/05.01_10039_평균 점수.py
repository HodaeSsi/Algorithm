inputList = []

for i in range(5):
    tmp = int(input())

    if tmp < 40:
        inputList.append(40)
    else:
        inputList.append(tmp)

answer = sum(inputList) // 5
print(answer)
