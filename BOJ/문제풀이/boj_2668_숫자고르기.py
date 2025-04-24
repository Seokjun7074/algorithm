import sys

input = sys.stdin.readline


def dfs(cur, start):
    visited[cur] = True
    nextNum = data[cur]
    if not visited[nextNum]:
        dfs(nextNum, start)
    elif visited[nextNum] and nextNum == start:
        result.append(start)


n = int(input())
data = [0] + [int(input()) for _ in range(n)]
result = []
for i in range(1, n + 1):
    visited = [False] * (n + 1)
    dfs(i, i)
print(len(result))
result.sort()
for i in result:
    print(i)
