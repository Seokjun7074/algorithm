from collections import deque


def solution(bridge_length, weight, truck_weights):
    time = 0
    q = deque(truck_weights)
    bridge = deque()
    curW = 0

    while q:
        time += 1

        if len(bridge) > 0 and bridge[0][1] == time:  # 다리 건널 시간 되면 pop 해줌
            outTruck = bridge.popleft()
            curW -= outTruck[0]

        if curW + q[0] <= weight:
            curT = q.popleft()
            curW += curT
            bridge.append(
                [curT, time + bridge_length]
            )  # 현재 다리를 건너는 트럭무게와 나가는 시간

    return time + bridge_length
