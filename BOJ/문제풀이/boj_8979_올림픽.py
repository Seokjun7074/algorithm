import sys

input = sys.stdin.readline

n, k = map(int, input().split())
team = []
for i in range(n):
    team.append(list(map(int, input().split())))
team.sort(key=lambda x: (-x[1], -x[2], -x[3]))


for i in range(n):
    if team[i][0] == k:
        index = i

for i in range(n):
    if team[index][1:] == team[i][1:]:
        print(i + 1)
        break
