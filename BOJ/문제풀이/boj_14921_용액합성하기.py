import sys

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))

answer = sys.maxsize

for i in range(N - 1):
    left = i + 1
    right = N - 1
    while left <= right:
        mid = (left + right) // 2
        s = arr[i] + arr[mid]
        if s == 0:
            answer = 0
            break
        if s < 0:
            left = mid + 1
        if s > 0:
            right = mid - 1
        if abs(s) < abs(answer):
            answer = s
print(answer)
