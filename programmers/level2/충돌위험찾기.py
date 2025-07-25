def solution(points, routes):
    answer = 0
    total_movement = []
    for route in routes:
        si, sj = points[route[0] - 1]
        movement = [(si, sj, 0)]  # 이동경로와 시간 모음
        cnt = 0
        for idx in range(len(route) - 1):
            si, sj = points[route[idx] - 1]
            ei, ej = points[route[idx + 1] - 1]
            while True:
                if si == ei and sj == ej:
                    break
                if si < ei:
                    si += 1
                    cnt += 1
                elif si > ei:
                    si -= 1
                    cnt += 1
                elif sj < ej:
                    sj += 1
                    cnt += 1
                elif sj > ej:
                    sj -= 1
                    cnt += 1
                movement.append((si, sj, cnt))
        total_movement += movement

    d = {}
    for move in total_movement:
        if move in d:
            d[move] += 1
        else:
            d[move] = 1
    for z in d:
        if 1 < d[z]:
            answer += 1
    return answer
