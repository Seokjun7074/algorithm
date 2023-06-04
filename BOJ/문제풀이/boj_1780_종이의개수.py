import sys

input = sys.stdin.readline

N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]

result = {-1: 0, 0: 0, 1: 0}


def dfs(x, y, n):
    cur = paper[x][y]
    for i in range(x, x + n):
        for j in range(y, y + n):
            if paper[i][j] != cur:
                next = n // 3
                dfs(x, y, next)
                dfs(x, y + next, next)
                dfs(x, y + (next * 2), next)
                dfs(x + next, y, next)
                dfs(x + next, y + next, next)
                dfs(x + next, y + (next * 2), next)
                dfs(x + (next * 2), y, next)
                dfs(x + (next * 2), y + next, next)
                dfs(x + (next * 2), y + (next * 2), next)
                return
    result[cur] += 1
    return


dfs(0, 0, N)
for i in result.values():
    print(i)
