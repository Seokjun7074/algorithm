import sys
from collections import deque

N, M = map(int, input().split())
memories = [0] + list(map(int, input().split()))
costs = [0] + list(map(int, input().split()))
answer = sum(costs) + 1
length = sum(costs) + 1


backpack = [[0] * length for _ in range(N + 1)]

for i in range(1, N + 1):
    m, c = memories[i], costs[i]
    for j in range(length):
        backpack[i][j] = backpack[i - 1][j]
        if c > j:
            continue
        backpack[i][j] = max(backpack[i - 1][j], m + backpack[i - 1][j - c])
        if backpack[i][j] >= M:
            answer = min(answer, j)

print(answer)
