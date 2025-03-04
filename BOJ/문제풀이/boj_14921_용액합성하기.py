import sys

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))

answer = sys.maxsize

left = 0
right = N - 1
while left < right:
    s = arr[left] + arr[right]
    if s == 0:
        answer = 0
        break
    if s < 0:
        left += 1
    if s > 0:
        right -= 1
    if abs(s) < abs(answer):
        answer = s
print(answer)
