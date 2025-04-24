import sys

input = sys.stdin.readline
N = int(input())
arr = [[i for i in range(N + 1)]]
tmp_arr = [0]
for _ in range(N):
    tmp_arr.append(int(input()))
arr.append(tmp_arr)


def dfs(start, cur, v):
    v[cur] += 1
    nextNum = arr[1][cur]
    if start == nextNum:
        v[nextNum] += 1
        for i in range(1, N + 1):
            if v[i] == 2:
                answer[i] = 1
        return
    if v[nextNum] == 0:
        v[nextNum] += 1
        dfs(start, nextNum, v)


answer = [0] * (N + 1)
for i in range(1, N + 1):
    v = [0] * (N + 1)
    dfs(i, i, v)

cnt = 0
for num in answer:
    if num > 0:
        cnt += 1
print(cnt)
for i in range(1, N + 1):
    if answer[i] > 0:
        print(i)
