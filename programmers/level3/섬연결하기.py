import heapq, sys


def solution(n, costs):
    answer = 0
    bridge = [[] for _ in range(n)]
    for start, end, w in costs:
        bridge[start].append((w, end))
        bridge[end].append((w, start))

    v = [False] * n
    q = [(0, 0)]  # 0번 섬부터 시작 (가중치, 번호)
    heapq.heapify(q)
    print(bridge)

    while q:
        cur_w, cur_b = heapq.heappop(q)
        if v[cur_b]:
            continue
        v[cur_b] = True
        answer += cur_w

        for w, b in bridge[cur_b]:
            if not v[b]:
                heapq.heappush(q, (w, b))

    return answer
