import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
link = [0] * 101
v = [False] * 101
v[0] = True

for _ in range(N):
    f, t = map(int, input().split())
    link[f] = t
for _ in range(M):
    f, t = map(int, input().split())
    link[f] = t


def bfs(start, inputCount):
    q = deque()
    q.append([start, inputCount])
    v[start] = True

    while q:
        cur = q.popleft()
        position = cur[0]
        cnt = cur[1]
        if position == 100:
            print(cnt)
            break
        for dice in range(1, 7):
            next = position + dice
            if next > 100 or v[next]:
                continue
            v[next] = True
            if link[next] != 0:
                q.append([link[next], cnt + 1])
            else:
                q.append([next, cnt + 1])


bfs(1, 0)
