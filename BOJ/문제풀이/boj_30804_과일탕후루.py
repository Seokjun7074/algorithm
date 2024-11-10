import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split(" ")))
start, end, result = 0, 0, 0
fruit = {}

diff = 0

while end < N:
    if arr[end] in fruit:
        fruit[arr[end]] += 1
    else:
        fruit[arr[end]] = 1
        diff += 1
    while diff > 2:
        fruit[arr[start]] -= 1
        if fruit[arr[start]] == 0:
            del fruit[arr[start]]
            diff -= 1
        start += 1
    result = max(result, end - start + 1)
    end += 1

print(result)
