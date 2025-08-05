def solution(sticker):
    answer = 0
    N = len(sticker)
    if len(sticker) < 3:
        return max(sticker)
    first = sticker[: N - 1]
    second = sticker[1:]

    dp1 = [0] * (N - 1)
    dp1[0] = first[0]
    dp1[1] = max(dp1[0], first[1])

    dp2 = [0] * (N - 1)
    dp2[0] = second[0]
    dp2[1] = max(dp2[0], second[1])

    for i in range(2, N - 1):
        dp1[i] = max(dp1[i - 1], dp1[i - 2] + first[i])
        dp2[i] = max(dp2[i - 1], dp2[i - 2] + second[i])

    answer = max(max(dp1), max(dp2))
    return answer
