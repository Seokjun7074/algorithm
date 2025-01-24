from collections import deque


def solution(numbers):
    answer = [-1] * len(numbers)
    arr = []
    for i in range(len(numbers)):
        arr.append((numbers[i], i))
    stack = []
    q = deque(arr)

    while q:
        target = q.popleft()
        stack.append(target)
        if len(q) == 0:
            continue
        while stack and stack[-1][0] < q[0][0]:
            answer[stack[-1][1]] = q[0][0]
            stack.pop()

    return answer
