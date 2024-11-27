import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())
MAX_VALUE = 100001
visited = [0] * MAX_VALUE
time = MAX_VALUE
cnt = 0

deq = deque()
deq.append([N, 0])
visited[N] = 0

while deq:
    curPos, curCount = deq.popleft()

    if curCount > time:
        continue

    if curPos == K:
        if time == MAX_VALUE:
            time = curCount

        if curCount == time:
            cnt += 1

    arr = [curPos - 1, curPos + 1, curPos * 2]

    for a in arr:
        if 0 <= a < MAX_VALUE and (visited[a] == 0 or visited[a] == curCount + 1):
            visited[a] = curCount + 1
            deq.append([a, curCount + 1])
print(time)
print(cnt)
