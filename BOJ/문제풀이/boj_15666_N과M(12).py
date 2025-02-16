import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = sorted(list(set(list(map(int, input().split())))))
N = len(arr)
v = [0] * N


def dfs(idx, cnt):
    global before
    if cnt == M:
        answer = []
        for vi in range(N):
            if v[vi] > 0:
                for j in range(v[vi]):
                    answer.append(arr[vi])
        print(*answer)
        return
    for i in range(idx, N):
        v[i] += 1
        dfs(i, cnt + 1)
        v[i] -= 1


for i in range(N):
    v[i] += 1
    dfs(i, 1)
    v[i] -= 1
