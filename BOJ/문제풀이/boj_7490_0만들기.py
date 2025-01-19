import sys

input = sys.stdin.readline

N = int(input())


def dfs(cur, lastNum, codeList):
    if cur >= lastNum:
        answer = codeList.replace(" ", "")
        if eval(answer) == 0:
            print(codeList)
        return
    cur += 1
    dfs(cur, lastNum, codeList + " " + str(cur))
    dfs(cur, lastNum, codeList + "+" + str(cur))
    dfs(cur, lastNum, codeList + "-" + str(cur))


for _ in range(N):
    n = int(input())
    dfs(1, n, "1")
    print()
