import sys
from itertools import combinations

input = sys.stdin.readline
N = int(input())
arr = []
dic = {}

for _ in range(N):
    n = int(input())
    arr.append(n)

arr.sort(reverse=True)
for i in range(N):
    for j in range(i, N):
        n = arr[i] + arr[j]
        if n in dic:
            dic[n] += 1
        else:
            dic[n] = 1
answer = -1
for i in range(N):
    for j in range(i + 1, N):
        n = arr[i] - arr[j]
        if n in dic:
            answer = max(answer, arr[i])

print(answer)
