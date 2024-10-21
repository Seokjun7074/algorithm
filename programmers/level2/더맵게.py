import heapq


def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)

    while scoville:
        min_1 = heapq.heappop(scoville)
        if min_1 < K:
            if len(scoville) == 0:
                return -1
            min_2 = heapq.heappop(scoville)
            heapq.heappush(scoville, min_1 + (min_2 * 2))
            answer += 1

    return answer
