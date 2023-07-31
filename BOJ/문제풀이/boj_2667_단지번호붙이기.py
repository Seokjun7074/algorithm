import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

g = []
result = []

for _ in range(N):
    g.append(list(map(int, input().strip())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]


def bfs(g, a, b):
    q = deque()
    q.append([a, b])
    g[a][b] = 0
    count = 1

    while q:
        x, y = q.popleft()
        g[x][y] = 0
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= len(g) or ny < 0 or ny >= len(g):
                continue

            if g[nx][ny] == 1:
                g[nx][ny] = 0
                q.append([nx, ny])
                count += 1

    return count


for i in range(N):
    for j in range(N):
        if g[i][j] == 1:
            count = bfs(g, i, j)
            result.append(count)

result.sort()

print(len(result))
for k in result:
    print(k)
