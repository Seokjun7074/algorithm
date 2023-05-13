from collections import deque

q = deque()

N, M, V = map(int, input().split())
g = [[0] * (N + 1) for _ in range(N + 1)]
v1 = [False] * (N + 1)
v2 = [False] * (N + 1)
for _ in range(M):
    start, end = map(int, input().split())
    g[start][end] = 1
    g[end][start] = 1


def bfs(start):
    v1[start] = True
    q.append(start)
    while q:
        cur = q.popleft()
        print(cur, end=" ")
        for i in range(N + 1):
            if not v1[i] and g[cur][i] > 0:
                q.append(i)
                v1[i] = True


def dfs(start):
    v2[start] = True
    print(start, end=" ")
    for i in range(N + 1):
        if not v2[i] and g[start][i] > 0:
            dfs(i)


dfs(V)
print()
bfs(V)
