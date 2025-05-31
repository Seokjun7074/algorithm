import sys

input = sys.stdin.readline
inputString = input().rstrip()
target = input().rstrip()
targetLength = len(target)
stack = []


for s in inputString:
    stack.append(s)
    if len(stack) < targetLength:
        continue
    cnt = 0
    for i in range(1, targetLength + 1):
        idx = -i
        if target[idx] == stack[idx]:
            cnt += 1
        else:
            break
    if cnt == targetLength:
        for _ in range(targetLength):
            stack.pop()
if len(stack) == 0:
    print("FRULA")
else:
    print("".join(stack))
