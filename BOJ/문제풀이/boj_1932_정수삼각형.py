import sys

input = sys.stdin.readline
N = int(input())
tri = []
dp = []
for _ in range(N):
    tri.append(list(map(int, input().split())))
for i in range(N):
    dp.append([0] * (i + 1))

dp[0][0] = tri[0][0]

for i in range(1, N):
    for j in range(len(dp[i])):
        left, right = 0, 0
        if j - 1 >= 0 and j - 1 < len(dp[i - 1]):
            left = dp[i - 1][j - 1]
        if j >= 0 and j < len(dp[i - 1]):
            right = dp[i - 1][j]
        dp[i][j] = tri[i][j] + max(left, right)

print(max(dp[len(dp) - 1]))
