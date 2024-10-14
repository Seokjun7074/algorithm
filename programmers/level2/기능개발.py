from collections import deque


def solution(progresses, speeds):
    answer = []
    q = deque()
    for i in range(len(progresses)):
        day = (100 - progresses[i]) // speeds[i]
        other = (100 - progresses[i]) % speeds[i]
        if other == 0:
            q.append(day)
        else:
            q.append(day + 1)
    firstDeploy = q.popleft()
    cnt = 1
    while q:
        nextDeploy = q.popleft()
        if firstDeploy >= nextDeploy:
            cnt += 1
        else:
            firstDeploy = nextDeploy
            answer.append(cnt)
            cnt = 1
    answer.append(cnt)
    return answer
