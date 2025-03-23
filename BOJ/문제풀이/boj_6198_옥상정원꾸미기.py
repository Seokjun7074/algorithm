import sys

input = sys.stdin.readline
N = int(input())
buildings = [int(input()) for _ in range(N)]

stack = []
answer = 0

for h in buildings:
    print(h, stack)
    while stack and stack[-1] <= h:  # 현재 빌딩보다 낮은 빌딩은 필요 없음 (pop)
        stack.pop()
    print(stack)
    answer += len(stack)  # 스택에 남아 있는 빌딩 수만큼 count
    stack.append(h)  # 현재 빌딩 push

print(answer)
