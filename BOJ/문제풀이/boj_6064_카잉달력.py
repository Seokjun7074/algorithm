import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    M, N, x, y = map(int, input().split())
    result = -1
    nx = x
    while nx <= M * N:
        if (nx - y) % N == 0:
            result = nx
            break
        nx += M
    print(result)
