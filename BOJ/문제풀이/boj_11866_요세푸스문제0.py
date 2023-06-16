from collections import deque
import sys

input = sys.stdin.readline

N, K = map(int, input().split())
q = deque()
ans = []

for x in range(1, N + 1):
    q.append(x)

while q:
    for x in range(K - 1):
        num = q.popleft()
        q.append(num)
    delete = q.popleft()
    ans.append(delete)
print("<", end="")
print(", ".join(map(str, ans)), end="")
print(">")
