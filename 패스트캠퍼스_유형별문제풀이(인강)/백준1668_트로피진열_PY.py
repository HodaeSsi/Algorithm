N = int(input())

trophy = []
for i in range(N):
    trophy.append(int(input()))

#left
maxHeight = 0
visible = 0
for i in trophy:
    if i > maxHeight:
        visible += 1
        maxHeight = i
print(visible)

#right
maxHeight = 0
visible = 0
for i in list(reversed(trophy)):
    if i > maxHeight:
        visible += 1
        maxHeight = i
print(visible)
    
#list.reverse() // reversed() 메서드
#급 의문: 파이썬 스트링표현에서 \나, '같은거 표현하고싶으면?