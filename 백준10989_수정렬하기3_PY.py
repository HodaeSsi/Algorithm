import sys

N = int(sys.stdin.readline())

result  = {}

for i in range(N):
    n = sys.stdin.readline()
    try:
        result["" + n] = result["" + n] + 1
    except KeyError:
        result["" + n] = 1
keyList_int = []
for i in result.keys():
    keyList_int.append(int(i))
keyList_int.sort()

for i in keyList_int:
    for j in range(result["" + str(i) + "\n"]):
        print(i)
'''
for i in range(N):
    n = input()
    try:
        result["" + n] = result["" + n] + 1
    except KeyError:
        result["" + n] = 1

keyList_int = []
for i in result.keys():
    keyList_int.append(int(i))
keyList_int.sort()
print('---')
for i in keyList_int:
    for j in range(result["" + str(i)]):
        print(int(i))
'''        