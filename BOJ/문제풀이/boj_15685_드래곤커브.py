import sys

input = sys.stdin.readline
n = int(input())
MAX_RANGE = 101


graph = [[0] * MAX_RANGE for _ in range(MAX_RANGE)]
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

for i in range(n):

    y, x, d, g = map(int, input().split(" "))
    graph[x][y] = 1

    curve = [d]
    for j in range(g):
        for k in range(len(curve) - 1, -1, -1):
            curve.append((curve[k] + 1) % 4)

    # 드래곤 커브 만들기
    for j in range(len(curve)):
        x += dx[curve[j]]
        y += dy[curve[j]]
        if x < 0 or x >= MAX_RANGE or y < 0 or y >= MAX_RANGE:
            continue

        graph[x][y] = 1

answer = 0
for i in range(MAX_RANGE - 1):
    for j in range(MAX_RANGE - 1):
        if (
            graph[i][j] == 1
            and graph[i + 1][j] == 1
            and graph[i][j + 1] == 1
            and graph[i + 1][j + 1] == 1
        ):
            answer += 1

print(answer)
