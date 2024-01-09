N, K = map(int, input().split())

weight = list(map(int, input().split()))

visited = [0] * N
result = 0


def dfs(cnt, w):
    global result

    if w < 0:
        return
    if cnt >= N:
        result += 1
        return

    for i in range(N):
        if visited[i] == 0:
            visited[i] = 1
            dfs(cnt + 1, w + weight[i] - K)
            visited[i] = 0


dfs(0, 0)

print(result)
