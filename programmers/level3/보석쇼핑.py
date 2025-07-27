def solution(gems):
    answer = [1, len(gems)]

    d = dict()
    MAX_GEM = len(set(gems))

    start, end = 0, 0
    cur_length = float("inf")

    while end < len(gems):
        cur_gem = gems[end]
        end += 1
        if cur_gem in d:
            d[cur_gem] += 1
        else:
            d[cur_gem] = 1

        while len(d) == MAX_GEM:
            if end - start + 1 < cur_length:
                answer = [start + 1, end]
                cur_length = end - start + 1

            front_gem = gems[start]
            d[front_gem] -= 1
            start += 1

            if d[front_gem] == 0:
                del d[front_gem]

    return answer
