import sys
from collections import deque

input = sys.stdin.readline

N, Q = map(int, input().split())

graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    p, q, r = map(int, input().split())
    graph[p].append((q, r))
    graph[q].append((p, r))


def bfs(k, start):
    queue = deque([start])
    visited = [False] * (N + 1)
    visited[start] = True
    count = 0
    while queue:
        cur = queue.popleft()
        for nxt, usado in graph[cur]:
            if not visited[nxt] and usado >= k:
                visited[nxt] = True
                queue.append(nxt)
                count += 1

    return count


for _ in range(Q):
    k, v = map(int, input().split())
    print(bfs(k, v))
