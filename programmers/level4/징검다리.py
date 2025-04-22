def solution(distance, rocks, n):
    answer = 0
    rocks.sort()

    left = 0
    right = distance

    while left <= right:
        mid = (left + right) // 2
        prev_rock = 0
        cnt = 0

        for rock in rocks:
            if rock - prev_rock < mid:
                cnt += 1  # 제거
            else:
                prev_rock = rock  # 유지
        if distance - prev_rock < mid:
            cnt += 1

        if cnt > n:
            right = mid - 1
        else:
            answer = mid
            left = mid + 1

    return answer
