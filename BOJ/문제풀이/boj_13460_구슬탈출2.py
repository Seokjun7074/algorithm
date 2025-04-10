import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
g = [list(input().rstrip()) for _ in range(N)]

# 구슬 위치 찾기
blue_i, blue_j, red_i, red_j = 0, 0, 0, 0
for i in range(N):
    for j in range(M):
        if g[i][j] == "B":
            blue_i, blue_j = i, j
        if g[i][j] == "R":
            red_i, red_j = i, j

# 상하좌우
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

# 방문 체크
visited = set()
q = deque()
q.append((red_i, red_j, blue_i, blue_j, 0))  # 초기 카운트 0
visited.add((red_i, red_j, blue_i, blue_j))


# 구슬 이동 함수
def move(y, x, d):
    cnt = 0
    while True:
        if g[y + dy[d]][x + dx[d]] == "#":
            break
        y += dy[d]
        x += dx[d]
        cnt += 1
        if g[y][x] == "O":
            break
    return y, x, cnt


answer = -1

while q:
    ri, rj, bi, bj, depth = q.popleft()

    if depth >= 10:
        break
    flag = False
    for d in range(4):
        nri, nrj, rcnt = move(ri, rj, d)
        nbi, nbj, bcnt = move(bi, bj, d)

        if g[nbi][nbj] == "O":  # 파란 공 빠지면 실패
            continue
        if g[nri][nrj] == "O":  # 빨간 공만 빠짐
            answer = depth + 1
            flag = True
            break

        # 겹침 처리
        if nri == nbi and nrj == nbj:
            # 빨간공이 늦게 도착
            if rcnt > bcnt:
                nri -= dy[d]
                nrj -= dx[d]
            # 파란 공이 늦게 도착
            else:
                nbi -= dy[d]
                nbj -= dx[d]

        if (nri, nrj, nbi, nbj) not in visited:
            visited.add((nri, nrj, nbi, nbj))
            q.append((nri, nrj, nbi, nbj, depth + 1))
    if flag:
        break
print(answer)
