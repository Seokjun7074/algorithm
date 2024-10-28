import sys

input = sys.stdin.readline

N, M = map(int, input().split())
g = [list(map(int, input().split())) for _ in range(N)]

for _ in range(2):
    start, end = map(int, input().split())
    for i in range(start - 1, end):
        if 1 in g[i]:
            g[i].remove(1)
            g[i].append(0)
cnt = 0
for i in range(N):
    for j in range(M):
        if g[i][j] == 1:
            cnt += 1
print(cnt)
