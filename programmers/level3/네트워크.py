from collections import deque


def solution(n, computers):
    answer = 0
    q = deque()
    v = [False] * n

    for i in range(n):
        if v[i] == False:
            q.append(i)
            v[i] = True
            while q:
                cur = q.popleft()
                for x in range(n):
                    if computers[cur][x] == 1 and v[x] == False:
                        v[x] = True
                        q.append(x)
            answer += 1

    return answer
