import sys

input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))[::-1]
answer = []
stack = []

for num in arr:

    while stack and stack[-1] <= num:
        stack.pop()
    if len(stack) < 1:
        stack.append(num)
        answer.append(-1)
        continue
    answer.append(stack[-1])
    stack.append(num)

answer = " ".join(list(map(str, answer[::-1])))
print(answer)
