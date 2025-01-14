import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()


# [1,7,8,9]
def dfs(idx, num):
    if len(num) == M:
        for n in num:
            print(n, end=" ")
        print()
        return
    for x in range(idx, N):
        num.append(arr[x])
        dfs(x, num)
        num.pop()


dfs(0, [])
