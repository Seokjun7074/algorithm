import sys

input = sys.stdin.readline

N = int(input())
arr = []

for _ in range(N):
    start, end = map(int, input().split())
    arr.append([start, end])

newArr = sorted(arr, key=lambda x: (x[1], x[0]))

cnt = 1
using = newArr[0]
for x in range(1, N):
    if using[1] <= newArr[x][0]:
        cnt += 1
        using = newArr[x]

print(cnt)
