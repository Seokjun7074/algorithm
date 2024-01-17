def dfs(depth, idx):
    global result
    if depth == N // 2:
        power1, power2 = 0, 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    power1 += graph[i][j]
                elif not visited[i] and not visited[j]:
                    power2 += graph[i][j]
        result = min(result, abs(power1 - power2))
        return

    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            dfs(depth + 1, i + 1)
            visited[i] = False


N = int(input())

visited = [False] * N
graph = [list(map(int, input().split())) for _ in range(N)]
result = 100

dfs(0, 0)
print(result)
