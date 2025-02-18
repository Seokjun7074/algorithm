import sys, heapq

input = sys.stdin.readline

N, E = map(int, input().split())
graph = [[] for _ in range(N + 1)]
for _ in range(E):
    s, e, v = map(int, input().split())
    graph[s].append((e, v))  # 도착노드, 가중치
    graph[e].append((s, v))  # 도착노드, 가중치

d1, d2 = map(int, input().split())


def dijkstra(start, target):
    global graph
    d = [sys.maxsize] * (N + 1)
    d[start] = 0
    pq = [(d[start], start)]  # 가중치, 도착 노드

    while pq:
        curW, node = heapq.heappop(pq)
        # 작업하려는 노드(curW)가 현재까지의 최단거리(d[node])보다 크면 안봐도 됨
        if curW > d[node]:
            continue
        for nextNode, nextW in graph[node]:
            newW = curW + nextW
            if newW < d[nextNode]:  # 새로운 거리의 합이 더 작다면
                d[nextNode] = newW
                heapq.heappush(pq, (newW, nextNode))
    return d[target]


answer1 = dijkstra(1, d1) + dijkstra(d1, d2) + dijkstra(d2, N)
answer2 = dijkstra(1, d2) + dijkstra(d2, d1) + dijkstra(d1, N)
if min(answer1, answer2) >= sys.maxsize:
    print(-1)
else:
    print(min(answer1, answer2))
