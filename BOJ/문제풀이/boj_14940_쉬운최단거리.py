import sys
from collections import deque

input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

N, M = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(N)]
visited = [[-1] * M for _ in range(N)]


def bfs(i, j):
    q = deque()
    q.append([i, j])
    visited[i][j] = 0

    while q:
        cur = q.popleft()
        x = cur[0]
        y = cur[1]
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if nx >= 0 and ny >= 0 and nx < N and ny < M and visited[nx][ny] == -1:
                if map[nx][ny] == 0:
                    visited[nx][ny] = 0
                else:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append([nx, ny])


for i in range(N):
    for j in range(M):
        if map[i][j] == 2 and visited[i][j] == -1:
            bfs(i, j)

for i in range(N):
    for j in range(M):
        if map[i][j] == 0:
            print(0, end=" ")
        else:
            print(visited[i][j], end=" ")
    print()
