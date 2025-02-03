import sys

input = sys.stdin.readline
N, S = map(int, input().split())
arr = list(map(int, input().split()))

answer = N + 1
first = 0
second = 0
cnt = arr[0]

while first <= second:
    if cnt >= S:
        answer = min(answer, second - first + 1)
        cnt -= arr[first]
        first += 1
    else:
        second += 1
        if second < N:
            cnt += arr[second]
        else:
            break

print(0 if answer == N + 1 else answer)
