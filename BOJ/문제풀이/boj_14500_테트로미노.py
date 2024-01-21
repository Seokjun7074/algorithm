N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
maxValue = 0


def dfs(i, j, cur, cnt):
    global maxValue
    if cnt == 4:
        maxValue = max(cur, maxValue)
        return
    for n in range(4):
        nx = i + dx[n]
        ny = j + dy[n]
        if nx >= 0 and ny >= 0 and nx < N and ny < M and not visited[nx][ny]:
            visited[nx][ny] = True
            dfs(nx, ny, cur + board[nx][ny], cnt + 1)
            visited[nx][ny] = False


def cross(i, j):
    global maxValue
    for n in range(4):
        sumValue = board[i][j]
        for k in range(3):
            t = (n + k) % 4
            nx = i + dx[t]
            ny = j + dy[t]
            if nx >= 0 and ny >= 0 and nx < N and ny < M:
                sumValue += board[nx][ny]
        maxValue = max(maxValue, sumValue)


for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(i, j, board[i][j], 1)
        visited[i][j] = False
        cross(i, j)
print(maxValue)
