import sys

sys.setrecursionlimit(10**7)
input = sys.stdin.readline

N, M = map(int, input().split())
graph = list([] for _ in range(N + 1))
count = 0

for _ in range(M):
    i, j = map(int, input().split())
    graph[i].append(j)
    graph[j].append(i)

v = [False] * (N + 1)


def dfs(start):
    v[start] = True

    for x in graph[start]:
        if not v[x]:
            dfs(x)


for i in range(1, N + 1):
    if not v[i]:
        dfs(i)
        count += 1

print(count)
