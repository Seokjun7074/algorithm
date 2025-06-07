import heapq


def solution(n, edge):
    answer = 0
    node = [[] for _ in range(n + 1)]
    for s, e in edge:
        node[s].append(e)
        node[e].append(s)

    def dijkstra():
        v = [False] * (n + 1)
        pq = [(0, 1)]  # (비용, 현재노드)

        dist = [float("inf")] * (n + 1)
        dist[1] = 0

        while pq:
            cost, curNode = heapq.heappop(pq)

            for nextNode in node[curNode]:
                nextCost = 1 + cost
                if dist[nextNode] <= nextCost:
                    continue
                dist[nextNode] = nextCost
                heapq.heappush(pq, (nextCost, nextNode))
        return dist[1:]

    d = dijkstra()
    maxDist = max(d)

    for x in d:
        if maxDist == x:
            answer += 1
    return answer
