import sys

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    N = int(input())
    dic = {}
    result = {}
    dead = []
    players = list(map(int, input().split()))
    for p in players:
        if p in dic:
            dic[p] += 1
        else:
            dic[p] = 1
            result[p] = []
    for x in dic:
        if dic[x] < 6:
            dead.append(x)
    cnt = 1
    for p in players:
        if p in dead:
            continue
        result[p].append(cnt)
        cnt += 1
    sameResult = []
    win = sys.maxsize
    for x in result:
        if len(result[x]) == 6:
            if win > sum(result[x][:4]):
                win = sum(result[x][:4])
                sameResult = []
                sameResult.append(x)
            elif win == sum(result[x][:4]):
                sameResult.append(x)
    realMin = sys.maxsize
    answer = -1
    for x in sameResult:
        if realMin > sum(result[x][:5]):
            realMin = sum(result[x][:5])
            answer = x
    print(answer)
