from collections import deque

N, M = map(int, input().split())
si, sj, ei, ej = map(int, input().split())

warriors = []
wl = list(map(int, input().split()))
for i in range(0, M * 2 - 1, 2):
    warriors.append((wl[i], wl[i + 1]))
# print(warriors)

g = [list(map(int, input().split())) for _ in range(N)]


def findRoute(si, sj, ei, ej):
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    v = [[0] * N for _ in range(N)]
    q = deque([(si, sj)])

    while q:
        ci, cj = q.popleft()

        if (ci, cj) == (ei, ej):
            route = []
            ci, cj = v[ci][cj]  # 목적지 이전 위치
            while (ci, cj) != (si, sj):
                route.append((ci, cj))
                ci, cj = v[ci][cj]
            return (True, route[::-1])

        for d in range(4):
            ni = ci + dy[d]
            nj = cj + dx[d]
            if (
                ni < 0
                or ni >= N
                or nj < 0
                or nj >= N
                or v[ni][nj] != 0
                or g[ni][nj] == 1
            ):
                continue
            v[ni][nj] = (ci, cj)
            q.append((ni, nj))
    return (False, [])


def makeStone(warrior_map, mi, mj, dr):
    v = [[0] * N for _ in range(N)]  # 메누사 시선 닿는곳
    stoneCnt = 0
    # 1.메두사 위치 기준 직선으로 조지기
    for d in range(1, N):
        ni = mi + di[dr] * d
        nj = mj + dj[dr] * d
        if ni < 0 or ni >= N or nj < 0 or nj >= N:
            break
        if warrior_map[ni][nj] > 0:
            stoneCnt += warrior_map[ni][nj]
            v[ni][nj] += 1
            break
        v[ni][nj] += 1
    # 2.dr+1 dr-1 돌면서 구하기
    left_dr = (dr - 1) % 8
    right_dr = (dr + 1) % 8
    # 왼쪽
    for side_dr in (left_dr, right_dr):
        for d in range(1, N):  # 메두사 기준 대각
            ni = mi + di[side_dr] * d
            nj = mj + dj[side_dr] * d
            if ni < 0 or ni >= N or nj < 0 or nj >= N:
                break
            for dw in range(N):
                wi = ni + di[dr] * dw
                wj = nj + dj[dr] * dw
                if wi < 0 or wi >= N or wj < 0 or wj >= N or warrior_map[wi][wj] == -1:
                    break
                if warrior_map[wi][wj] > 0:
                    stoneCnt += warrior_map[wi][wj]
                    v[wi][wj] += 1
                    for k in range(1, N):  # 전사 기준 대각
                        bi = wi + di[side_dr] * k
                        bj = wj + dj[side_dr] * k
                        if bi < 0 or bi >= N or bj < 0 or bj >= N:
                            break
                        warrior_map[bi][bj] = -1
                    break
                v[wi][wj] += 1
    # for z in v:
    #     print(*z)
    # print()
    # for z in warrior_map:
    #     print(*z)
    # print(stoneCnt)
    # print("-----------")
    return (v, stoneCnt)


# 전사들 이동
def moveWarriors(v, mi, mj):
    # (상하좌우), (좌우상하) 메두사 시야가 아니면 (!=1)
    move, attk = 0, 0

    for dirs in (
        ((-1, 0), (1, 0), (0, -1), (0, 1)),
        ((0, -1), (0, 1), (-1, 0), (1, 0)),
    ):
        for idx in range(len(warriors) - 1, -1, -1):
            ci, cj = warriors[idx]
            if v[ci][cj] == 1:  # 메두사 시야
                continue

            dist = abs(mi - ci) + abs(mj - cj)  # 현재거리
            for di, dj in dirs:
                ni, nj = ci + di, cj + dj
                # 범위내 메두사시야 아니고 현재보다 줄어드는 방향이면 (상하좌우 우선순위로 이동)
                if (
                    0 <= ni < N
                    and 0 <= nj < N
                    and v[ni][nj] != 1
                    and dist > abs(mi - ni) + abs(mj - nj)
                ):
                    if (ni, nj) == (mi, mj):
                        attk += 1  #
                        warriors.pop(idx)
                    else:
                        warriors[idx] = (ni, nj)
                    move += 1
                    break
    return move, attk


# 상,우상, 우,우하, 하,좌하, 좌,좌상
#  0,  1,  2,  3,  4,  5,  6,  7
di = [-1, -1, 0, 1, 1, 1, 0, -1]
dj = [0, 1, 1, 1, 0, -1, -1, -1]
# movement, medusa_route = False, []
movement, medusa_route = findRoute(si, sj, ei, ej)
if not movement:
    print(-1)
else:
    for mi, mj in medusa_route:
        # 이동하면서 만나는 전사 제거로직
        for i in range(len(warriors) - 1, -1, -1):
            if warriors[i] == (mi, mj):
                warriors.pop(i)

        # 전사 위치 표시한 지도
        warrior_map = [[0] * N for _ in range(N)]
        for wi, wj in warriors:
            warrior_map[wi][wj] += 1

        max_stone = -1  # 최대 돌로 만드는 전사 수
        v = []  # 현재 메두사의 시선
        # 시선 갈기기
        for dr in (0, 4, 6, 2):  # 상하좌우 순서로 처리!
            tmpVisited, stonedCnt = makeStone(warrior_map, mi, mj, dr)
            if max_stone < stonedCnt:
                max_stone = stonedCnt
                v = tmpVisited
        # for z in v:
        #     print(*z)

        # 전사 이동
        move, attack = moveWarriors(v, mi, mj)
        print(move, max_stone, attack)
    print(0)

# 메두사 이동 - findRoute
# 메두사 시선 처리
# 전사 이동
# 출력

# warrior_map = [[0] * N for _ in range(N)]
# for wi, wj in [(4, 2), (4, 4), (4, 4), (6, 6)]:
#     warrior_map[wi][wj] += 1
# makeStone(warrior_map, 0, 4, 4)
