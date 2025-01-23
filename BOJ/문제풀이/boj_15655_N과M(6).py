import sys

input = sys.stdin.readline
N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()

v = [False] * N


def dfs(num, idx):
    if len(num) == M:
        for n in num:
            print(n, end=" ")
        print()
        return
    for i in range(idx, N):
        if v[i]:
            continue
        v[i] = True
        num.append(arr[i])
        dfs(num, i)
        num.pop()
        v[i] = False


dfs([], 0)
