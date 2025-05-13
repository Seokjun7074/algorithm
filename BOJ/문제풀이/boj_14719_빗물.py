import sys

input = sys.stdin.readline

H, W = map(int, input().split())
world = list(map(int, input().split()))

visited = [[0] * W for _ in range(H)]

for i in range(W):
    height = world[i]
    for h in range(H - 1, H - height - 1, -1):
        visited[h][i] = 1

answer = 0


# 1부터 w-1까지 탐색
def bfs(si, sj):
    flag = False
    cnt = 0
    if sj == 0:
        flag = True
    for x in range(sj, W):
        if visited[si][x] != 0:
            break
        if x == W - 1:
            flag = True
        visited[si][x] = 2
        cnt += 1

    if flag:
        return 0
    else:
        return cnt


for i in range(H - 1, -1, -1):
    for j in range(W):
        if visited[i][j] == 0:
            answer += bfs(i, j)
print(answer)
