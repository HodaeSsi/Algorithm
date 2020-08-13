word = list(input().split(' '))
A = list(word[0])
for i in word[1::]:
    B = list(i)
    temp = []
    for j in range(min(len(A),len(B))):
        if A[j] == B[j]:
            temp.append(A[j])
        else:
            A = temp
            break

print(len(A))
#!!! 답지 이해가 안되네;; !!