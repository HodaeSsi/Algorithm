doc = input()
word = input()

count = 0
wordFind = 0

for i in range(len(doc)):
    if wordFind != 0:
        wordFind = wordFind - 1
        continue

    #print(str(i) + ": " + doc[i: i+len(word): 1]) #[ : : ]("step"???) >> str(list) 초과 범위 index는 알아서 거르네???
    if word == doc[i: i+len(word): 1]:
        count = count + 1
        wordFind = len(word) - 1

print(count)
        