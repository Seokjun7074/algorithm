import sys
from collections import deque

sys.stdin = open("../input.txt")

T = int(input())


# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
# 중복조합 필요
def perm(n, r, arr):  # nCr
    if len(arr) == r:
        permList.append(arr[:])
        return
    for i in range(n):
        arr.append(i)
        perm(n, r, arr)
        arr.pop()


def deepcopy(arr):
    newArr = []
    for i in range(H):
        a = []
        for j in range(W):
            a.append(arr[i][j])
        newArr.append(a)
    return newArr


def bomb(i, j, power, g):
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    q = deque()
    q.append((i, j, power))
    while q:
        curI, curJ, curPower = q.popleft()
        for d in range(4):
            for k in range(curPower):
                ni = curI + dy[d] * k
                nj = curJ + dx[d] * k
                if ni < 0 or ni >= H or nj < 0 or nj >= W or g[ni][nj] == 0:
                    continue
                q.append((ni, nj, g[ni][nj]))
                g[ni][nj] = 0


def downBrick(g):
    for j in range(W):
        nonZero = []
        for i in range(H):
            if g[i][j] != 0:
                nonZero.append(g[i][j])

        for i in range(H - 1, -1, -1):
            if nonZero:
                g[i][j] = nonZero.pop()
            else:
                g[i][j] = 0
    return g


def countBrick(g):
    cnt = 0
    for i in range(H):
        for j in range(W):
            if g[i][j] > 0:
                cnt += 1
    return cnt


for test_case in range(1, T + 1):
    N, W, H = map(int, input().split())
    cell = [list(map(int, input().split())) for _ in range(H)]
    permList = []
    # 중복순열 구하기
    perm(W, N, [])
    # bomb(2,2,g[2][2],g)
    # downBrick(g)
    # for x in g:
    #     print(x)
    answer = W * H + 1
    for seq in permList:
        newG = deepcopy(cell)
        seq_cnt = 0
        for start in seq:
            for y in range(H):
                if newG[y][start] > 0:
                    bomb(y, start, newG[y][start], newG)
                    downBrick(newG)
                    break
        seq_cnt += countBrick(newG)
        answer = min(answer, seq_cnt)
    print(f"#{test_case} {answer}")
