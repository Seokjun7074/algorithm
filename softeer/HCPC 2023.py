import sys

input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
X = 0  # 철민 현재 인기도

dp = [[0, 0] for _ in range(N)]  # dp[i][0]은 방문O / dp[i][1]은 방문X

p1, c1 = arr[0]
if abs(p1 - 0) <= c1:
    dp[0][0] = 1

for i in range(1, N):
    p, c = arr[i]
    gap1 = abs(p - dp[i - 1][0])  # 이전에도 방문 지금도 방문
    gap2 = abs(p - dp[i - 1][1])  # 이전에는 방문 X 지금은 방문
    cur1 = dp[i - 1][0]
    cur2 = dp[i - 1][1]

    if gap1 <= c:
        cur1 += 1
    if gap2 <= c:
        cur2 += 1
    dp[i][0] = max(cur1, cur2)
    dp[i][1] = dp[i - 1][1]

print(max(dp[N - 1][0], dp[N - 1][1]))
# 현재 인기도 x = 0
# i번 사람 인기도 Pi, 친화력 Ci
# |P - X| <= C 이어야 x+1
