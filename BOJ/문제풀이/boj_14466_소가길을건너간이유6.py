import sys
from collections import deque

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N, K, R = map(int, input().split())

bridges = [[[] for _ in range(N)] for _ in range(N)]
for _ in range(R):
    r1, c1, r2, c2 = map(int, input().split())
    r1, c1, r2, c2 = r1 - 1, c1 - 1, r2 - 1, c2 - 1
    bridges[r1][c1].append((r2, c2))
    bridges[r2][c2].append((r1, c1))

cows = []
for _ in range(K):
    r, c = map(int, input().split())
    cows.append((r - 1, c - 1))


def bfs(sx, sy):
    visited = [[False] * N for _ in range(N)]
    q = deque()
    q.append((sx, sy))
    visited[sx][sy] = True

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if (nx, ny) in bridges[x][y]:  # 길이 막혀 있는 경우
                    continue
                visited[nx][ny] = True
                q.append((nx, ny))
    return visited


# 전체 소 쌍 중 서로 도달할 수 없는 쌍 수 계산
answer = 0
for i in range(K):
    visited = bfs(cows[i][0], cows[i][1])

    for j in range(i + 1, K):
        if not visited[cows[j][0]][cows[j][1]]:
            answer += 1

print(answer)
