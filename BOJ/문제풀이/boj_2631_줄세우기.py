import sys

input = sys.stdin.readline
N = int(input())
children = []

for _ in range(N):
    children.append(int(input()))


dp = [1] * N  # 현재 인덱스까지 최장 부분수열의 길이
for i in range(1, N):
    for j in range(i):
        if children[j] < children[i]:
            dp[i] = max(dp[j] + 1, dp[i])
print(N - max(dp))
# 0번 인덱스부터 보면서 오름차순이 아닌애들 수 구함
# 3 7 5 2 6 1 4
