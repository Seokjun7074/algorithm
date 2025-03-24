import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
dx = [0, 1, 0, -1]  # D(오른쪽)일 때 +1 (시계방향)
dy = [1, 0, -1, 0]

g = [[0] * n for _ in range(n)]
v = [[0] * n for _ in range(n)]

# 사과 입력
k = int(input())
for _ in range(k):
    i, j = map(int, input().split())
    g[i - 1][j - 1] = 1

l = int(input())
command = {}
for _ in range(l):
    X, C = input().split()
    command[int(X)] = C

# 초기 상태
q = deque([(0, 0)])
direction = 0  # 처음에는 오른쪽
time = 0  #  시간
v[0][0] = 1

while True:
    time += 1
    x, y = q[-1]  # 현재 머리 위치
    nx, ny = x + dx[direction], y + dy[direction]  # 다음 머리 위치

    if not (0 <= nx < n and 0 <= ny < n) or v[nx][ny]:
        print(time)
        break

    # 머리 이동
    q.append((nx, ny))
    v[nx][ny] = 1  # 방문 표시

    # 사과가 있으면 꼬리를 유지
    if g[nx][ny] == 1:
        g[nx][ny] = 0
    else:
        tx, ty = q.popleft()
        v[tx][ty] = 0  # 꼬리가 있던 자리 비우기

    if time in command:
        if command[time] == "D":
            direction = (direction + 1) % 4
        elif command[time] == "L":
            direction = (direction + 3) % 4
