import sys
from collections import deque

input = sys.stdin.readline
N, M, F = map(int, input().split())
g = [list(map(int, input().split())) for _ in range(N)]
wall = {}  # 동,서,남,북,위
di = [0, 0, 1, -1]  # 동서남북
dj = [1, -1, 0, 0]


def rotateWall(l, d):  # 동서남북위
    newList = [[0] * M for _ in range(M)]
    if d == 0:  # 동
        for i in range(M):
            for j in range(M):
                newList[i][j] = l[j][M - 1 - i]
    elif d == 1:  # 서
        for i in range(M):
            for j in range(M):
                newList[i][j] = l[M - 1 - j][i]
    elif d == 2:  # 남
        for i in range(M):
            for j in range(M):
                newList[i][j] = l[i][j]
    elif d == 3:  # 북
        for i in range(M):
            for j in range(M):
                newList[i][j] = l[M - 1 - i][M - 1 - j]
    elif d == 4:  # 위
        for i in range(M):
            for j in range(M):
                newList[i][j] = l[i][j]
    return newList


# 출구 찾기
def findExit(i, j):
    q = deque([(i, j)])
    v = [[False] * N for _ in range(N)]
    v[i][j] = True
    while q:
        ci, cj = q.popleft()
        for d in range(4):
            ni = ci + di[d]
            nj = cj + dj[d]
            if g[ni][nj] == 0:
                # print(ci - startWI, cj - startWJ)
                wall[d][ci - startWI][cj - startWJ] = 3
                return (ni, nj, d)  # 출구 좌표, 방향(동서남북)
            if 0 <= ni < N and 0 <= nj < N and not v[ni][nj] and g[ni][nj] == 3:
                v[ni][nj] = True
                q.append((ni, nj))


def findTimeMachine():
    for i in range(M):
        for j in range(M):
            if wall[4][i][j] == 2:
                return i, j


# 시간의 벽에서 탈출
def escapeWall():
    v = {}
    for i in range(5):
        v[i] = [[0] * M for _ in range(M)]
    si, sj = findTimeMachine()
    q = deque([(si, sj, 0, 4)])  # 윗면 시작
    v[4][si][sj] = 1

    while q:
        ci, cj, cnt, cd = q.popleft()
        if wall[cd][ci][cj] == 3:
            return cnt + 1

        for d in range(4):
            ni = ci + di[d]
            nj = cj + dj[d]

            # 이동이 정상 범위면 같은 면에서 계속 이동
            if 0 <= ni < M and 0 <= nj < M:
                if v[cd][ni][nj] == 0 and wall[cd][ni][nj] != 1:
                    v[cd][ni][nj] = 1
                    q.append((ni, nj, cnt + 1, cd))
                continue

            # 여기서부터는 면을 넘어가는 경우 처리
            if cd == 4:  # 윗면
                if ni < 0:  # 북쪽으로 넘어감
                    ti, tj, td = M - 1, nj, 3
                elif ni >= M:  # 남쪽으로 넘어감
                    ti, tj, td = 0, nj, 2
                elif nj < 0:  # 서쪽으로 넘어감
                    ti, tj, td = ni, M - 1, 1
                elif nj >= M:  # 동쪽으로 넘어감
                    ti, tj, td = ni, 0, 0
                else:
                    continue

            elif cd == 0:  # 동쪽
                if ni < 0:
                    ti, tj, td = M - 1 - nj, M - 1, 3
                elif ni >= M:
                    ti, tj, td = nj, M - 1, 2
                elif nj < 0:
                    ti, tj, td = ni, M - 1, 4
                else:
                    continue

            elif cd == 1:  # 서쪽
                if ni < 0:
                    ti, tj, td = nj, 0, 3
                elif ni >= M:
                    ti, tj, td = M - 1 - nj, 0, 2
                elif nj >= M:
                    ti, tj, td = ni, 0, 4
                else:
                    continue

            elif cd == 2:  # 남쪽
                if ni < 0:
                    ti, tj, td = M - 1, nj, 4
                elif nj < 0:
                    ti, tj, td = M - 1, M - 1 - ni, 1
                elif nj >= M:
                    ti, tj, td = M - 1, ni, 0
                else:
                    continue

            elif cd == 3:  # 북쪽
                if ni >= M:
                    ti, tj, td = 0, nj, 4
                elif nj < 0:
                    ti, tj, td = 0, ni, 1
                elif nj >= M:
                    ti, tj, td = 0, M - 1 - ni, 0
                else:
                    continue

            # 면 전환 후 방문 및 벽 확인
            if 0 <= ti < M and 0 <= tj < M:
                if v[td][ti][tj] == 0 and wall[td][ti][tj] != 1:
                    v[td][ti][tj] = 1
                    q.append((ti, tj, cnt + 1, td))
    return -1


def diffuseVirus():
    vq = deque()
    virus_check = [[0] * N for _ in range(N)]
    for vi, vj, vd, vc in virus:
        vq.append((vi, vj, vd, vc, vc))
        virus_check[vi][vj] = 1

    while vq:
        vi, vj, vd, vc, curTime = vq.popleft()
        ni = vi + di[vd]
        nj = vj + dj[vd]
        if 0 <= ni < N and 0 <= nj < N and g[ni][nj] == 0:
            if virus_check[ni][nj] > 0:
                virus_check[ni][nj] = min(virus_check[ni][nj], curTime)
            else:
                virus_check[ni][nj] = curTime
            vq.append((ni, nj, vd, vc, curTime + vc))
    return virus_check


def escapeSpace(exitI, exitJ, escapeTime):
    q = deque([(exitI, exitJ, escapeTime)])
    v = [[False] * N for _ in range(N)]
    virus_check = diffuseVirus()
    v[exitI][exitJ] = True

    while q:
        ci, cj, cnt = q.popleft()
        if (ci, cj) == (targetI, targetJ):
            return cnt

        for d in range(4):
            ni = ci + di[d]
            nj = cj + dj[d]
            if (
                0 <= ni < N
                and 0 <= nj < N
                and not v[ni][nj]
                and g[ni][nj] != 1
                and g[ni][nj] != 3
            ):
                if virus_check[ni][nj] == 0 or virus_check[ni][nj] > cnt + 1:
                    v[ni][nj] = True
                    q.append((ni, nj, cnt + 1))

    return -1


for d in range(5):
    l = [list(map(int, input().split())) for _ in range(M)]
    rotateWall(l, d)
    wall[d] = rotateWall(l, d)

startWI, startWJ = 0, 0
exitI, exitJ = 0, 0  # 미지의 공간 의 탈출 좌표
exitDirection = -1  # 시간의벽 어느 방향에 출구가 있는가
targetI, targetJ = 0, 0
virus = []  # 시간이상현상

for _ in range(F):
    virus.append(list(map(int, input().split())))

for i in range(N):
    flag = False
    for j in range(N):
        if g[i][j] == 3:
            startWI, startWJ = i, j
            exitI, exitJ, exitDirection = findExit(i, j)
            flag = True
            break
    if flag:
        break
for i in range(N):
    for j in range(N):
        if g[i][j] == 4:
            targetI, targetJ = i, j

escapeTime = escapeWall()
if escapeTime == -1:
    print(-1)
else:
    print(escapeSpace(exitI, exitJ, escapeTime))


# 미지의 공간과 시간의 벽 존재
# 타임머신의 위치 (2): 시간의 벽 윗면에 존재
# 시간의 벽(3), 탈출구(4): 미지의 공간에 존재

# F개의 '시간 이상 현상'
# v배수 턴마다 d방향으로 확산
# 장애물과 탈출구가 없는 방향으로 확산
# 타임머신은 시간 이상 현상이 확산되는 곳으로 이동 불가
