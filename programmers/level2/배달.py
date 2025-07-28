import heapq


def solution(N, road, K):
    hq = []
    answer = 0
    delivery = [float("inf")] * (N + 1)
    delivery[1] = 0
    g = [[0] * (N + 1) for _ in range(N + 1)]

    for s, e, w in road:
        if g[s][e] > 0:
            g[s][e] = min(g[s][e], w)
            g[e][s] = min(g[e][s], w)
        else:
            g[s][e] = w
            g[e][s] = w

    heapq.heappush(hq, (0, 1))
    while hq:
        curW, curNode = heapq.heappop(hq)
        for nextNode in range(len(g[curNode])):
            nextWeight = g[curNode][nextNode]
            if curW + nextWeight >= delivery[nextNode] or nextWeight <= 0:
                continue
            delivery[nextNode] = curW + nextWeight
            heapq.heappush(hq, (curW + nextWeight, nextNode))

    for i in range(1, N + 1):
        if delivery[i] <= K:
            answer += 1
    return answer
