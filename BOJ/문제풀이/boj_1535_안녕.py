import sys

input = sys.stdin.readline
n = int(input())
life = [0] + list(map(int, input().split()))
happy = [0] + list(map(int, input().split()))


MAX_LIFE = 100
dp = list([0] * MAX_LIFE for _ in range(n + 1))  # i명, j명줄까지 최대 happy

for i in range(1, n + 1):  # 사람
    for j in range(MAX_LIFE):  # 명줄
        if j < life[i]:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i - 1][j], happy[i] + dp[i - 1][j - life[i]])
print(dp[-1][-1])
