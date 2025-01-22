import sys

input = sys.stdin.readline

N, S = map(int, input().split())
arr = list(map(int, input().split()))
v = [False] * (N)
answer = 0


def dfs(sumNum, idx, depth):
    global answer
    if depth > N:
        return
    if sumNum == S and depth > 0:
        answer += 1
    for i in range(idx, N):
        if v[i]:
            continue
        sumNum += arr[i]
        v[i] = True
        dfs(sumNum, i, depth + 1)
        sumNum -= arr[i]
        v[i] = False


dfs(0, 0, 0)
print(answer)
