eat = []
drink = []

for i in range(3):
    eat.append(int(input()))

for i in range(2):
    drink.append(int(input()))

setList = []
for i in eat:
    for j in drink:
        setList.append(i + j - 50)

print(min(setList))