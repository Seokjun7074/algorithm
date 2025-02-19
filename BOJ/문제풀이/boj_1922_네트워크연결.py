import sys, heapq

input = sys.stdin.readline
N = int(input())
M = int(input())

g = [[] for _ in range(N + 1)]
for _ in range(M):
    s, e, c = map(int, input().split())
    g[s].append((e, c))  # (노드, 비용)
    g[e].append((s, c))  # (노드, 비용)

pq = [(0, 1)]
v = [False] * (N + 1)
answer = 0


while pq:
    cost, node = heapq.heappop(pq)
    if v[node]:
        continue
    answer += cost
    v[node] = True
    for nextNode, nextCost in g[node]:
        if v[nextNode]:
            continue
        heapq.heappush(pq, (nextCost, nextNode))
print(answer)
