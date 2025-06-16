import sys

input = sys.stdin.readline

N, B = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]


def calc(a1, a2):
    newArr = [[0] * N for _ in range(N)]
    for row in range(N):
        for col in range(N):
            for i in range(N):
                newArr[row][col] += a1[row][i] * a2[i][col]
            newArr[row][col] = newArr[row][col] % 1000
    return newArr


def square(arr, m):
    if m == 1:
        for i in range(N):
            for j in range(N):
                arr[i][j] %= 1000
        return arr
    half = m // 2
    tmp = square(arr, half)
    if m % 2 == 1:
        return calc(calc(tmp, tmp), arr)
    else:
        return calc(tmp, tmp)


answer = square(A, B)
for z in answer:
    print(*z)
