import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr = sorted(arr)
# N = len(arr)
v = [False] * (N)
answer = []


def dfs(num, cnt):
    if cnt == M:
        print(" ".join(map(str, num)))
        return
    prev = -1
    for x in range(N):
        if not v[x] and arr[x] != prev:
            v[x] = True
            num.append(arr[x])
            dfs(num, cnt + 1)
            num.pop()
            v[x] = False
            prev = arr[x]


dfs([], 0)
