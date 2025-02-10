import sys
from collections import deque

input = sys.stdin.readline

A, B = map(int, input().split())

answer = -1
q = deque()
q.append([A, 1])
while q:
    num, cnt = q.popleft()
    if num == B:
        answer = cnt
    if num * 2 <= B:
        q.append([num * 2, cnt + 1])
    if int(str(num) + "1") <= B:
        q.append([int(str(num) + "1"), cnt + 1])
print(answer)
