import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
sumArr = [0] * (N + 1)

count = [0] * (M + 1)

for i in range(N):
    sumArr[i + 1] = (sumArr[i] + arr[i]) % M
    count[sumArr[i + 1]] += 1

ans = count[0]

for i in range(M + 1):
    ans += (count[i] * (count[i] - 1)) // 2

print(ans)
