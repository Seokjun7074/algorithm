from collections import deque


def solution(priorities, location):
    answer = 0
    waiting = []
    for i in range(len(priorities)):
        waiting.append([priorities[i], i])

    q = deque(waiting)
    while q:
        cur = q.popleft()
        curValue = cur[0]
        curIndex = cur[1]
        if not q:
            return answer + 1
        maxValue = max(q)[0]
        if curValue >= maxValue:
            answer += 1
            if curIndex == location:
                return answer
        else:
            q.append(cur)
    return answer
