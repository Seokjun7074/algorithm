import sys

input = sys.stdin.readline
# [5, 1, 6, 2, 7, 3, 8]
N = int(input())
arr = list(map(int, input().split()))
dp = [0] * N  # 누적 길이
maxValue = arr[0]
for i in range(N):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j])
    dp[i] += 1  # 자기 자신 카운트
print(dp)
