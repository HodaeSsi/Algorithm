import sys

content = sys.stdin.read()
content = content.split('\n')
content = content[0:len(content)-1:]

for i in content:
    A, B = map(int, i.split(' '))
    print(A+B)

#다른 사람 코드!!!