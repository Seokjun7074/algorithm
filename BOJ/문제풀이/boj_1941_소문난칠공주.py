from collections import deque
from itertools import combinations
import sys

input = sys.stdin.readline

room = []
for x in range(5):
    room.append(list(map(str, input().rstrip())))


def bfs(i, j, friendSet):
    q = deque()
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    vv = [[False] * 5 for _ in range(5)]
    vv[i][j] = True
    q.append((i, j))
    cnt = 1
    while q:
        ci, cj = q.popleft()
        for k in range(4):
            nx = ci + dx[k]
            ny = cj + dy[k]
            if 0 <= nx < 5 and 0 <= ny < 5 and (nx, ny) in friendSet and not vv[nx][ny]:
                vv[nx][ny] = True
                q.append((nx, ny))
                cnt += 1
    if cnt == 7:
        return True
    return False


answer = 0
for friends in combinations(range(25), 7):
    scnt = 0
    friendSet = []
    for x in friends:
        r = x // 5
        c = x % 5
        friendSet.append((r, c))
        if room[r][c] == "S":
            scnt += 1
    if scnt < 4:

        continue
    i, j = friendSet[0]
    result = bfs(i, j, friendSet)
    if result:
        answer += 1

print(answer)
