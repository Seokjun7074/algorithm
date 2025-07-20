import math


def solution(n, stations, w):
    answer = 0
    network = []

    for i in range(1, len(stations)):
        gap = (stations[i] - w) - (stations[i - 1] + w) - 1
        network.append(gap)

    start = stations[0] - w - 1
    if start > 0:
        network.append(start)

    end = n - (stations[-1] + w)
    if end > 0:
        network.append(end)

    for net in network:
        answer += math.ceil(net / (w * 2 + 1))

    return answer
