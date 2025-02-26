def solution(k, m, score):
    answer = 0
    box = len(score) // m
    score.sort(reverse=True)
    idx = m - 1
    while box > 0:
        answer = answer + m * score[idx]
        idx += m
        box -= 1
    print(answer)
    return answer


solution(3, 4, [1, 2, 3, 1, 2, 3, 1])
solution(4, 3, [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2])
