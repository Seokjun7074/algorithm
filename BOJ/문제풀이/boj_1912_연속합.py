n = int(input())
arr = list(map(int, input().split()))
dp = [0] * n
dp[0] = arr[0]
for x in range(1, n):
    dp[x] = max(arr[x], dp[x - 1] + arr[x])

print(max(dp))
