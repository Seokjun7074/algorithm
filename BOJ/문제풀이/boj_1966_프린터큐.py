import sys
from collections import deque

input = sys.stdin.readline

TC = int(input())

for _ in range(TC):
    q = deque()
    length, target = map(int, input().split())
    arr = list(map(int, input().split()))
    for n in range(length):
        q.append([arr[n], n])
    cnt = 0
    while True:
        maxQueNum = max(q)[0]
        cur = q.popleft()
        curNum = cur[0]
        curIdx = cur[1]
        if curNum < maxQueNum:
            q.append(cur)
        else:
            if target == curIdx:
                print(cnt + 1)
                break
            cnt += 1
