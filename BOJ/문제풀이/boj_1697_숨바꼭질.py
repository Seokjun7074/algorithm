import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())
MAX_VALUE = 100001
visited = [0] * (MAX_VALUE + 1)
time = MAX_VALUE
cnt = 0

q = deque()
q.append([N, 0])
visited[N] = 1

while q:
    curPos, curCount = q.popleft()

    if curCount > time:
        continue

    if curPos == K:
        time = min(time, curCount)
        break

    arr = [curPos - 1, curPos + 1, curPos * 2]

    for a in arr:
        if 0 <= a < MAX_VALUE and (visited[a] == 0 or visited[a] == curCount + 1):
            visited[a] = curCount + 1
            q.append([a, curCount + 1])
print(time)
