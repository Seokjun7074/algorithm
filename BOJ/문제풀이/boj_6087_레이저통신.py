import sys
from collections import deque

input = sys.stdin.readline

W, H = map(int, input().split())
g = [list(input().strip()) for _ in range(H)]

# 레이저 시작점과 도착점 찾기
target = [(i, j) for i in range(H) for j in range(W) if g[i][j] == "C"]
(start_x, start_y), (end_x, end_y) = target

# 방향: 상, 하, 좌, 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 방문 배열 (방향별 최소 거울 설치 횟수 저장)
INF = float("inf")
visited = [[[INF] * 4 for _ in range(W)] for _ in range(H)]

# BFS 큐
queue = deque()

# 시작점에서 네 방향으로 출발
for d in range(4):
    nx, ny = start_x + dx[d], start_y + dy[d]
    if 0 <= nx < H and 0 <= ny < W and g[nx][ny] != "*":
        queue.append((nx, ny, d, 0))  # (x좌표, y좌표, 방향, 거울 설치 횟수)
        visited[nx][ny][d] = 0

while queue:
    x, y, direction, mirrors = queue.popleft()

    # 도착점에 도달한 경우 최소 거울 개수 반환
    if (x, y) == (end_x, end_y):
        print(mirrors)
        break

    # 같은 방향으로 이동 (거울 추가 없음)
    nx, ny = x + dx[direction], y + dy[direction]
    if 0 <= nx < H and 0 <= ny < W and g[nx][ny] != "*":
        if visited[nx][ny][direction] > mirrors:
            visited[nx][ny][direction] = mirrors
            queue.appendleft((nx, ny, direction, mirrors))  # 우선 탐색

    # 방향 바뀐
    for new_direction in range(4):
        if new_direction != direction:
            nx, ny = x + dx[new_direction], y + dy[new_direction]
            if 0 <= nx < H and 0 <= ny < W and g[nx][ny] != "*":
                if visited[nx][ny][new_direction] > mirrors + 1:
                    visited[nx][ny][new_direction] = mirrors + 1
                    queue.append((nx, ny, new_direction, mirrors + 1))
