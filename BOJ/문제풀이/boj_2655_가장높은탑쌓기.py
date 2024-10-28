import sys

input = sys.stdin.readline
N = int(input())

top = [[0, 0, 0, 0]]
for i in range(1, N + 1):
    width, height, weight = map(int, input().split())
    top.append([i, width, height, weight])

top.sort(key=lambda x: x[3])
# 정렬 후 top배열의 인덱스 기준으로 i번째 블럭 위에 쌓을 수 있는 높이
dp = [0] * (N + 1)

for i in range(1, N + 1):
    for j in range(i):
        if top[j][1] < top[i][1]:  # 현재 벽돌 i의 너비가 이전 벽돌 j보다 큰 경우
            dp[i] = max(dp[i], top[i][2] + dp[j])  # i의 누적 높이 비교
maxValue = max(dp)
result = []
idx = N
while idx != 0:
    if dp[idx] == maxValue:
        result.append(top[idx][0])  # 정렬 전 원래 인덱스 넣기
        maxValue -= top[idx][2]
    idx -= 1
result.reverse()
print(len(result))
for x in result:
    print(x)
