import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]
arr.sort()

answer = sys.maxsize
start = 0
end = 1

while start <= end:
    if end >= N:
        break
    s = arr[end] - arr[start]
    if s >= M:
        answer = min(answer, s)
        start += 1
    else:
        end += 1
print(answer)
