import sys

input = sys.stdin.readline

T = int(input())
P = [0] * 101
P[0] = 0
P[1] = 1
P[2] = 1
P[3] = 1


def pibo(x):
    if P[x]:
        return P[x]
    else:
        P[x] = pibo(x - 2) + pibo(x - 3)
        return P[x]


for x in range(T):
    N = int(input())
    print(pibo(N))
