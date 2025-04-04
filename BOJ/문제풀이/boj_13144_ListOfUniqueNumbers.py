import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
answer = 0
left = 0
right = 0

d = {}

while right < N:
    if arr[right] not in d:
        d[arr[right]] = 1
        answer += right - left + 1
        right += 1
    else:
        del d[arr[left]]
        left += 1
print(answer)
