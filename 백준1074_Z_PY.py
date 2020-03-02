def Z(N, r, c):
    result = 1
    if N == 0:
        return result
    else:
        if r < (2 ** N)/2 and c < (2 ** N/2):
            result = 0
            r, c = r, c
        elif r < (2 ** N)/2 and c >= (2 ** N/2):
            result = (2 ** (2 * N) / 4) * 1
            r, c = r, c - 2 ** (N - 1)
        elif r >= (2 ** N)/2 and c < (2 ** N/2):
            result = (2 ** (2 * N) / 4) * 2
            r, c = r - 2 ** (N -1), c
        elif r >= (2 ** N)/2 and c >= (2 ** N/2):
            #result = (2 ** (2 * N) / 4) * 3
            result = pow(2, 2 * N) / 4 * 3
            r, c = r - 2 ** (N -1), c - 2 ** (N - 1)

        return result + Z(N-1, r, c)

def ZZ(N, r, c):
    return Z(N, r, c) - 1

INPUT = list(map(int, input().split(' ')))
print(int(ZZ(INPUT[0], INPUT[1], INPUT[2])))

'''n, r, c = list(map(int, input().split(' ')))
print(n, r, c)'''
