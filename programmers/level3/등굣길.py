def solution(m, n, puddles):
    answer = 0
    cell = [[0] * (m + 1) for _ in range(n + 1)]
    dp = [[0] * (m + 1) for _ in range(n + 1)]

    for i, j in puddles:
        cell[j][i] = float("inf")
    dp[1][1] = 1

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if (i == 1 and j == 1) or cell[i][j] == float("inf"):
                continue
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

    return dp[n][m] % 1000000007
