import sys


input = sys.stdin.readline
R, C, M = map(int, input().split())
g = [[0] * C for _ in range(R)]

dy = [-1, 1, 0, 0]
dx = [0, 0, 1, -1]

answer = 0
shark = []
for _ in range(M):
    r, c, s, d, z = map(int, input().split())
    r -= 1
    c -= 1
    d -= 1  # 방향 1씩 감소해서 인덱스랑 맞춤
    g[r][c] = (s, d, z)  # 속도, 방향, 크기
    shark.append((r, c, s, d, z))


def huntShark(idx):
    hunt_result = 0
    for i in range(R):
        if g[i][idx] != 0:
            # 사냥한 상어 크기 저장
            hunt_result = g[i][idx][2]
            # 상어 제거
            g[i][idx] = 0
            break
    # shark list update
    for s in range(len(shark) - 1, -1, -1):
        i, j = shark[s][0], shark[s][1]
        if g[i][j] == 0:
            shark.pop(s)

    return hunt_result


def convertDirection(d):
    if d == 1:
        return 0
    elif d == 0:
        return 1
    elif d == 2:
        return 3
    elif d == 3:
        return 2


def moveShark(shark):
    move_result = []
    new_map = [[0] * C for _ in range(R)]  # 새로운 맵

    for i in range(len(shark)):
        r, c, s, d, z = shark[i]

        # 속도 최적화
        if d == 0 or d == 1:  # 상하 이동
            s %= (R - 1) * 2
        else:  # 좌우 이동
            s %= (C - 1) * 2

        # 이동 시작
        for _ in range(s):
            nr = r + dy[d]
            nc = c + dx[d]
            if 0 <= nr < R and 0 <= nc < C:
                r, c = nr, nc
            else:
                d = convertDirection(d)
                r += dy[d]
                c += dx[d]

        # 상어 겹침 처리
        if new_map[r][c] == 0 or new_map[r][c][2] < z:
            new_map[r][c] = (s, d, z)

    # 새로운 상어 목록 구성
    for i in range(R):
        for j in range(C):
            if new_map[i][j] != 0:
                move_result.append((i, j, *new_map[i][j]))

    # 원본 g 갱신
    for i in range(R):
        for j in range(C):
            g[i][j] = new_map[i][j]

    return move_result


for idx in range(C):
    hunt = 0
    # 1. 상어 사냥
    hunt += huntShark(idx)
    # 2. 상어 이동
    shark = moveShark(shark)
    answer += hunt

print(answer)
