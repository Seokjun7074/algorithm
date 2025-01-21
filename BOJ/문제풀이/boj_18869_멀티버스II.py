import sys

input = sys.stdin.readline
N, M = map(int, input().split())
u = {}
answer = 0
for _ in range(N):
    d = {}
    arr = list(map(int, input().split()))
    setedArr = list(set(arr))
    setedArr.sort()
    idxArr = []
    for i in range(len(setedArr)):
        if setedArr[i] not in d:
            d[setedArr[i]] = i
    for x in arr:
        idxArr.append(d[x])
    t = tuple(idxArr)
    if t in u:
        u[t] += 1
    else:
        u[t] = 1

for x in u:
    if u[x] > 1:
        answer += u[x] * (u[x] - 1) // 2
print(answer)
