from collections import deque


def solution(order):
    answer = 0
    q = deque(order)
    maxOrder = len(order)
    stack = []

    start = 1
    while start <= maxOrder:
        target = q[0]
        if target == start:
            q.popleft()
            answer += 1
            start += 1
            continue
        if len(stack) > 0 and stack[-1] == target:
            q.popleft()
            stack.pop()
            answer += 1
            continue
        else:
            stack.append(start)
            start += 1

    while q:
        if len(q) > 0 and len(stack) and q[0] == stack[-1]:
            q.popleft()
            stack.pop()
            answer += 1
        else:
            break

    return answer
