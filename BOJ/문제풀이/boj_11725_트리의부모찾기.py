import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
arr = [[] for _ in range(N + 1)]

for node in range(N - 1):
    start, end = map(int, input().split())
    arr[start].append(end)
    arr[end].append(start)

q = deque()
v = [False] * (N + 1)
v[0] = True
q.append(1)

answer = [0] * (N + 1)

while q:
    cur = q.popleft()
    for nextNode in arr[cur]:
        if not v[nextNode]:
            answer[nextNode] = cur
            v[nextNode] = True
            q.append(nextNode)

for x in range(2, N + 1):
    print(answer[x])
