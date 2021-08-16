#입력
n = input()
arr = []
for i in range(0, int(n)):
    temp = input()
    arr.append(int(temp))

count = 0
stack = []
string = []
isNo = False
#검사
for i in range(0, int(n)):
    #pop하려는 수가 지금까지 push한 수 중 가장 큰 수(count)보다 작은가 큰가
    #크다
    if arr[i] > count:
        #그 수까지 푸쉬
        for count in range(count + 1, arr[i] + 1):
            stack.append(count)
            string.append('+')

    #같다
    if arr[i] == count:
        #푸쉬 팝
        stack.pop()
        string.append('-')

    #작다
    if arr[i] < count:
        #스택검사
        #pop하려는 수가 top이다 아니다
        #맞다
        if arr[i] == stack[len(stack) - 1]:
            #pop
            stack.pop()
            string.append('-')
        #아니다
        else:
            #say no
            isNo = True
            break

if isNo == True:
    print("NO")
else:
    for i in string:
        print(i)