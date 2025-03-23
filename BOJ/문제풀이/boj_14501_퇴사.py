import sys

input = sys.stdin.readline
n = int(input())
time = []
pay = []
for _ in range(n):
    t, p = map(int, input().split())
    time.append(t)
    pay.append(p)

dp = [0] * (n + 1)  # dp[i]: i번째 날부터 퇴사일까지 얻을 수 있는 최대 수익

# 뒤에서부터 DP 계산
for i in range(n - 1, -1, -1):
    if i + time[i] <= n:  # 상담을 진행할 수 있는 경우
        dp[i] = max(dp[i + 1], pay[i] + dp[i + time[i]])
    else:  # 상담을 진행할 수 없는 경우 (넘어감)
        dp[i] = dp[i + 1]

print(dp[0])  # 첫날부터 얻을 수 있는 최대 이익
