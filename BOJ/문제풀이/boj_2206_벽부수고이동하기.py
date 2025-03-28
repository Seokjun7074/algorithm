import sys
from collections import deque

input = sys.stdin.readline
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

N, M = map(int, input().split())
g = [list(map(int, input().strip())) for _ in range(N)]

v = [[[0] * 2 for _ in range(M)] for _ in range(N)]

q = deque()
q.append((0, 0, 0, 1))  # i, j, block, cnt
v[0][0][0] = 1
answer = -1
while q:
    i, j, block, cnt = q.popleft()

    if i == N - 1 and j == M - 1:
        answer = cnt
        break

    for d in range(4):
        nx, ny = i + dx[d], j + dy[d]

        if 0 <= nx < N and 0 <= ny < M:
            if g[nx][ny] == 0 and v[nx][ny][block] == 0:
                v[nx][ny][block] = 1
                q.append((nx, ny, block, cnt + 1))

            if g[nx][ny] == 1 and block == 0 and v[nx][ny][1] == 0:
                v[nx][ny][1] = 1
                q.append((nx, ny, 1, cnt + 1))

print(answer)
