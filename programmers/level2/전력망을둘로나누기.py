from collections import deque


def bfs(g, v, startNode):
    cnt = 0
    q = deque()
    q.append(startNode)
    v[startNode] = True

    while q:
        cur = q.popleft()
        linked = g[cur]
        for x in linked:
            if v[x]:
                continue
            v[x] = True
            cnt += 1
            q.append(x)
    return cnt + 1


def solution(n, wires):
    answer = n + 1
    g = [[] for _ in range(n + 1)]
    for start, end in wires:
        g[start].append(end)
        g[end].append(start)

    for start, end in wires:
        visited = [False] * (len(g))
        visited[0] = True
        visited[end] = True
        cnt = bfs(g, visited, start)
        other = n - cnt
        answer = min(answer, abs(other - cnt))

    return answer
