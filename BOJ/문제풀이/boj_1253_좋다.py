import sys

input = sys.stdin.readline

N = int(input())
arr = sorted(list(map(int, input().split())))
answer = 0
m = max(arr)

d = dict()
check = set()
for x in arr:
    if x in d:
        d[x] += 1
    else:
        d[x] = 1

for i in range(N):
    start = 0
    end = N - 1
    while start < end:
        num = arr[end] + arr[start]
        if start == i:
            start += 1
            continue
        if end == i:
            end -= 1
            continue
        if num == arr[i]:
            answer += 1
            end -= 1
            break
        if num > arr[i]:
            end -= 1
        if num < arr[i]:
            start += 1
print(answer)
