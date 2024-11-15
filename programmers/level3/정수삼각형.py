def solution(triangle):
    answer = 0
    dp = []
    for i in range(1, len(triangle) + 1):
        dp.append([0] * i)
    dp[0][0] = triangle[0][0]
    for i in range(1, len(triangle)):
        depth = len(dp[i])
        for j in range(depth - 1):  # 이전
            for k in range(j, j + 2):  # 현재
                dp[i][k] = max(dp[i][k], dp[i - 1][j] + triangle[i][k])
    answer = max(dp[len(triangle) - 1])
    return answer
