import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
arr = []
answer = 0
for i in range(N):
    arr.append((int(input()), i))
building = deque(arr)
stack = []  # 계산 중인 건물들

while len(building) > 1:
    target = building.popleft()
    stack.append(target)
    while stack and building and stack[-1] <= building[0]:
        stack.pop()
    answer += len(stack)
print(answer)
