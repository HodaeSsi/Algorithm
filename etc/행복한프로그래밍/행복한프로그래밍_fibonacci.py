inputNum = input()

def fibonacci(i):
    if (i <= 2):
        return 1
    else:
        return fibonacci(i - 1) + fibonacci(i - 2)

for i in range(1, inputNum+1, 1):
    print("F(" + str(i) + ") = " + str(fibonacci(i)))


