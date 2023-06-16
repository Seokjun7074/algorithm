import sys

input = sys.stdin.readline

N, K = map(int, input().split())
temp = list(map(int, input().split()))
result = []
start = 0

for x in range(K):
    start += temp[x]
result.append(start)

for x in range(N - K):
    num = result[-1] - temp[x] + temp[x + K]
    result.append(num)

print(max(result))
