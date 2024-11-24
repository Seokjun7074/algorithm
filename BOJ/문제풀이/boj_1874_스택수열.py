import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
numberList = deque([i for i in range(1, N + 1)])
answer = [int(input()) for _ in range(N)]
stack = []  # 수열배열
result = []  # +-배열

cnt = 0
while len(stack) <= N:
    if cnt == N:
        break
    if len(stack) == 0 and len(numberList) > 0:
        num = numberList.popleft()
        stack.append(num)
        result.append("+")
    else:
        if stack[-1] == answer[cnt]:
            cnt += 1
            stack.pop()
            result.append("-")
        else:
            if len(numberList) <= 0:
                result = []
                break
            num = numberList.popleft()
            stack.append(num)
            result.append("+")
if len(result) == 0:
    print("NO")
else:
    for x in result:
        print(x)
