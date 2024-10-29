import sys
from itertools import permutations

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
result = []
for x in permutations(arr, M):
    result.append(x)
result.sort()
for j, x in enumerate(result):
    a = ""
    for i in range(M):
        a = a + " " + str(result[j][i])
    print(a.strip())
