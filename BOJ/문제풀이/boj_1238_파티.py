import sys, heapq

input = sys.stdin.readline

N, M, X = map(int, input().split())
g = [[] for _ in range(N + 1)]
for _ in range(M):
    s, e, c = map(int, input().split())
    g[s].append((e, c))  # 목적지, 비용

#  한 정점에서 다른 정점까지 최단거리


def dijkstra(start, end):
    v = [False] * (N + 1)
    dist = [sys.maxsize] * (N + 1)  # start 부터 각 정점까지의 최단거리
    dist[start] = 0
    v[start] = True
    pq = [(0, start)]
    while pq:
        cost, node = heapq.heappop(pq)
        if cost > dist[node]:
            continue
        # 현재 node와 연결된 노드들 순회
        for nextNode, nextCost in g[node]:
            newCost = nextCost + cost
            if newCost < dist[nextNode]:
                dist[nextNode] = newCost
                heapq.heappush(pq, (newCost, nextNode))
    return dist[end]


answer = [0] * (N + 1)
for i in range(1, N + 1):
    answer[i] = dijkstra(i, X) + dijkstra(X, i)
print(max(answer))
