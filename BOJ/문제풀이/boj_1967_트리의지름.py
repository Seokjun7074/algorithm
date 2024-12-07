import sys

input = sys.stdin.readline
sys.setrecursionlimit(10**5)

n = int(input())
tree = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    parent, child, weight = map(int, input().split())
    tree[parent].append((child, weight))
    tree[child].append((parent, weight))

visited = [-1] * (n + 1)
visited[1] = 0


def dfs(node, curW):
    for target, w in tree[node]:
        if visited[target] == -1:
            visited[target] = curW + w
            dfs(target, curW + w)

    return


dfs(1, 0)
idx, tmp = 0, 0
# 제일 먼곳 찾기
for i in range(1, len(visited)):
    if visited[i] > tmp:
        tmp = visited[i]
        idx = i

visited = [-1] * (n + 1)
visited[idx] = 0
dfs(idx, 0)

print(max(visited))
