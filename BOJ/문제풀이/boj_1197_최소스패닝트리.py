import sys, heapq

input = sys.stdin.readline

N, M = map(int, input().split())
g = [[] for _ in range(N + 1)]
for _ in range(M):
    s, e, c = map(int, input().split())
    g[s].append((e, c))  # (노드, 가중치)
    g[e].append((s, c))

pq = [(0, 1)]  # 가중치, 노드
v = [False] * (N + 1)
answer = 0
while pq:
    cost, node = heapq.heappop(pq)
    if v[node]:
        continue
    v[node] = True
    answer += cost
    for nextNode, nextCost in g[node]:
        if v[nextNode]:
            continue
        heapq.heappush(pq, (nextCost, nextNode))

print(answer)
