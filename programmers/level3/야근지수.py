import heapq


def solution(n, works):
    if sum(works) < n:
        return 0
    answer = 0
    hq = []
    for w in works:
        hq.append(-w)
    heapq.heapify(hq)

    while n > 0:
        m = heapq.heappop(hq)
        n -= 1
        heapq.heappush(hq, m + 1)

    for s in hq:
        answer += s**2
    return answer
