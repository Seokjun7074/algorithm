import sys

sys.setrecursionlimit(10**7)

input = sys.stdin.readline

N, r, c = map(int, input().split())
dy = [0, 0, 1, 1]
dx = [0, 1, 0, 1]


def zfunc(y, x, length, num):
    if length == 2:
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if ny == r and nx == c:
                print(num + k)
                return
        return
    mid = length // 2
    maxNum = length**2
    if r < y + mid and c < x + mid:  # 왼쪽 위
        zfunc(y, x, mid, num)
    elif r < y + mid and c >= x + mid:  # 오른쪽 위
        zfunc(y, x + mid, mid, num + maxNum // 4)
    elif r >= y + mid and c < x + mid:  # 왼쪽 아래
        zfunc(y + mid, x, mid, num + maxNum // 2)
    else:  # 오른쪽 아래
        zfunc(y + mid, x + mid, mid, num + 3 * maxNum // 4)


zfunc(0, 0, 2**N, 0)
