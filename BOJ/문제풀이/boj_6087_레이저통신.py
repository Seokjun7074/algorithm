import sys
from collections import deque

input = sys.stdin.readline

W, H = map(int, input().split())
g = list(input().rstrip() for _ in range(H))
C = []
for i in range(H):
    for j in range(W):
        if g[i][j] == "C":
            C.append((i, j))

(startX, startY), (endX, endY) = C

v = [list([sys.maxsize] * 4 for _ in range(W)) for _ in range(H)]


q = deque()
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for d in range(4):
    nx = startX + dx[d]
    ny = startY + dy[d]
    if 0 <= nx < H and 0 <= ny < W and g[nx][ny] != "*":
        q.append((nx, ny, d, 0))  # nx, ny, 방향, 거울 수


answer = sys.maxsize
while q:
    i, j, curD, mirrorCnt = q.popleft()
    if i == endX and j == endY:
        answer = min(answer, mirrorCnt)

    for d in range(4):
        nx = i + dx[d]
        ny = j + dy[d]
        if nx < 0 or nx >= H or ny < 0 or ny >= W or g[nx][ny] == "*":
            continue
        if v[nx][ny][d] < mirrorCnt:
            continue
        if d == curD:  # 같은 방향
            if v[nx][ny][d] > mirrorCnt:
                v[nx][ny][d] = mirrorCnt
                q.appendleft((nx, ny, d, mirrorCnt))  # 직진구간 우선 계산
        else:  # 다른 방향
            if v[nx][ny][d] > mirrorCnt + 1:
                v[nx][ny][d] = mirrorCnt + 1
                q.append((nx, ny, d, mirrorCnt + 1))
print(answer)
