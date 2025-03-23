import sys

input = sys.stdin.readline
n = int(input())
time = []
pay = []
for _ in range(n):
    t, p = map(int, input().split())
    time.append(t)
    pay.append(p)

v = [False] * n

answer = 0


def dfs(day, money):
    global answer
    if day >= n:
        answer = max(answer, money)
        return
    if day + time[day] <= n:
        dfs(day + time[day], money + pay[day])
    dfs(day + 1, money)


dfs(0, 0)
print(answer)
