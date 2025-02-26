def solution(distance, rocks, n):
    rocks.sort()  # 바위 정렬
    rocks.append(distance)  # 마지막 도착점 추가
    left, right = 1, distance  # 최소 거리의 범위 설정
    answer = 0

    while left <= right:
        mid = (left + right) // 2  # 중간값(최소 거리)
        prev, remove_count = 0, 0

        for rock in rocks:
            if rock - prev < mid:  # 거리가 mid보다 작으면 제거
                remove_count += 1
                if remove_count > n:
                    break
            else:
                prev = rock  # 바위를 제거하지 않으면 기준점 갱신

        if remove_count > n:  # 너무 많이 제거하면 거리 줄이기
            right = mid - 1
        else:  # 제거 개수가 충분하면 거리 늘리기
            answer = mid
            left = mid + 1

    return answer
