def solution(targets):
    answer = 0
    targets.sort(key=lambda x: x[1])
    cur = 0
    for target in targets:
        start = target[0]
        end = target[1]
        if cur <= start:
            answer += 1
            cur = end

    return answer
