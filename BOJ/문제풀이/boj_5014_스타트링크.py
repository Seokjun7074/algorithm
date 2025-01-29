import sys
from collections import deque

input = sys.stdin.readline

F, S, G, U, D = map(int, input().split())
q = deque()
v = [False] * (F + 1)
v[S] = True
q.append((S, 0))  # [현재 층, 카운트]

answer = sys.maxsize

while q:
    cur, cnt = map(int, q.popleft())
    if cur == G:
        answer = min(answer, cnt)
        break
    nextUp = cur + U
    nextDown = cur - D

    if 1 <= nextUp <= F and not v[nextUp]:
        v[nextUp] = True
        q.append((nextUp, cnt + 1))
    if 1 <= nextDown <= F and not v[nextDown]:
        v[nextDown] = True
        q.append((nextDown, cnt + 1))

if answer == sys.maxsize:
    print("use the stairs")
else:
    print(answer)
