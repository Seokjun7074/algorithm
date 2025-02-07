import sys
from itertools import combinations

input = sys.stdin.readline
home = []
chicken = []

N, M = map(int, input().split())
for i in range(N):
    arr = list(map(int, input().split()))
    for j in range(N):
        if arr[j] == 1:
            home.append((i, j))
        if arr[j] == 2:
            chicken.append((i, j))

g = [[0] * len(chicken) for _ in range(len(home))]
for i in range(len(home)):
    x1, y1 = home[i]
    for j in range(len(chicken)):
        x2, y2 = chicken[j]
        g[i][j] = abs(x1 - x2) + abs(y1 - y2)

answer = sys.maxsize
for picked in combinations(range(len(chicken)), M):
    chickenDist = 0
    for i in range(len(home)):
        num = sys.maxsize
        for j in picked:
            num = min(num, g[i][j])
        chickenDist += num
    answer = min(answer, chickenDist)
print(answer)
