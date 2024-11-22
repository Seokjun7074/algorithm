import sys, heapq

input = sys.stdin.readline

v, e = map(int, input().split())
initPosition = int(input())

node = [[] for _ in range(v + 1)]

for _ in range(e):
    s, t, w = map(int, input().split())
    node[s].append((t, w))


def dijkstra(start):
    pq = []
    heapq.heappush(pq, (0, start))

    path = [sys.maxsize] * (v + 1)
    path[start] = 0

    while pq:
        curWeight, curNode = heapq.heappop(pq)

        if curWeight > path[curNode]:
            continue

        for target, weight in node[curNode]:
            nextWeight = curWeight + weight
            if path[target] > nextWeight:
                path[target] = nextWeight
                heapq.heappush(pq, (nextWeight, target))

    for i in range(1, v + 1):
        if path[i] == sys.maxsize:
            print("INF")
        else:
            print(path[i])


dijkstra(initPosition)
