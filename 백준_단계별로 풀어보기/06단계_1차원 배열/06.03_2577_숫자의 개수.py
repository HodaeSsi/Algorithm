ABC = []
for i in range(3):
    ABC.append(int(input()))
multiple = ABC[0] * ABC[1] * ABC[2]

ABC = list(str(multiple))
lst = [0 for i in range(10)]
for i in ABC:
    lst[int(i)%10] += 1
for i in lst:
    print(i)