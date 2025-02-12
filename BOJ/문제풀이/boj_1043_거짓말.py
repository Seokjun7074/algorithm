import sys

input = sys.stdin.readline


def find(parent, x):
    if x != parent[x]:
        parent[x] = find(parent, parent[x])

    return parent[x]


def union(parent, a, b, truth):
    a = find(parent, a)
    b = find(parent, b)

    if a in truth and b in truth:
        return

    if a in truth:
        parent[b] = a
    elif b in truth:
        parent[a] = b
    else:
        if a < b:
            parent[b] = a
        else:
            parent[a] = b


N, M = map(int, input().split())
truth = list(map(int, input().split()))[1:]

parties = []
parent = list(range(N + 1))

for _ in range(M):
    members = list(map(int, input().split()))
    l = members[0]
    members = members[1:]

    for i in range(l - 1):
        union(parent, members[i], members[i + 1], truth)

    parties.append(members)

answer = 0
for members in parties:
    flag = True
    for m in members:
        if find(parent, m) in truth:
            flag = False
            break
    if flag:
        answer += 1

print(answer)
