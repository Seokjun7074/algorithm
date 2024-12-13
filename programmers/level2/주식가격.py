from collections import deque


def solution(prices):
    result = []
    queue = deque(prices)

    while queue:
        period = 0
        price = queue.popleft()

        for after in queue:
            period += 1
            if price > after:
                break
        result.append(period)

    return result
