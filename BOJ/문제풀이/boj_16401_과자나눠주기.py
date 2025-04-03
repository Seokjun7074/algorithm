import sys

input = sys.stdin.readline

M, N = map(int, input().split())
arr = list(map(int, input().split()))
# 길이를 어떻게 자를지가 기준
left = 1
right = max(arr)
answer = 0
while left <= right:
    mid = (left + right) // 2

    cnt = 0
    for num in arr:
        cnt += num // mid
    if cnt >= M:
        left = mid + 1
        answer = mid
    else:
        right = mid - 1
print(answer)
