import sys

input = sys.stdin.readline

N = int(input())
stack = []
cnt = 0
for _ in range(N):
    num, height = map(int, input().split())
    if height == 0:
        cnt += len(stack)
        stack = []
        continue
    while stack and stack[-1] > height:
        stack.pop()
        cnt += 1
    if stack and stack[-1] == height:
        continue
    stack.append(height)


print(cnt + len(stack))
