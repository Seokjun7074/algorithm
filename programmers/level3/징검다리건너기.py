def solution(stones, k):
    answer = 0
    left, right = 1, max(stones)
    while left <= right:
        mid = (left + right) // 2
        cnt = 0

        for stone in stones:
            if stone - mid <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k:
                break

        if cnt >= k:  # 못건너는 경우
            answer = mid
            right = mid - 1
        else:  # 건너는 경우
            left = mid + 1

    return answer
