import sys
from collections import deque

input = sys.stdin.readline
N, M, K = map(int, input().split())

cell = [list(map(int, input().split())) for _ in range(N)]


def roll(dir):
    if dir == 0:  # 동
        # 밑0, 위1, 동2, 서3, 앞4, 뒤5
        (dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]) = (
            dice[2],
            dice[3],
            dice[1],
            dice[0],
            dice[4],
            dice[5],
        )
    elif dir == 1:  # 남
        # 밑0, 위1, 동2, 서3, 앞4, 뒤5
        (dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]) = (
            dice[4],
            dice[5],
            dice[2],
            dice[3],
            dice[1],
            dice[0],
        )
    elif dir == 2:  # 서
        # 밑0, 위1, 동2, 서3, 앞4, 뒤5
        dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = (
            dice[3],
            dice[2],
            dice[0],
            dice[1],
            dice[4],
            dice[5],
        )
    elif dir == 3:  # 북
        # 밑0, 위1, 동2, 서3, 앞4, 뒤5
        (dice[0], dice[1], dice[2], dice[3], dice[4], dice[5]) = (
            dice[5],
            dice[4],
            dice[2],
            dice[3],
            dice[0],
            dice[1],
        )


def getPoint(ci, cj, startNum):
    q = deque()
    q.append((ci, cj))
    v = list([False] * M for _ in range(N))
    v[ci][cj] = True
    cnt = 1

    while q:
        i, j = q.popleft()
        for d in range(4):
            ni = i + dy[d]
            nj = j + dx[d]
            if ni < 0 or ni >= N or nj < 0 or nj >= M or v[ni][nj]:
                continue
            if cell[ni][nj] != startNum:
                continue
            v[ni][nj] = True
            cnt += 1
            q.append((ni, nj))
    return cnt * startNum


direction = 0  # 이동 방향
dice = [6, 1, 3, 4, 5, 2]  # 밑 위 동 서 앞 뒤
dy = [0, 1, 0, -1]  # 동 남 서 북
dx = [1, 0, -1, 0]
ci, cj = 0, 0

answer = 0
for _ in range(K):

    # 벽 만나면 방향 반대 전환
    if (
        ci + dy[direction] < 0
        or ci + dy[direction] >= N
        or cj + dx[direction] < 0
        or cj + dx[direction] >= M
    ):
        direction = (direction + 2) % 4
    ni = ci + dy[direction]
    nj = cj + dx[direction]
    # 주사위 회전
    roll(direction)
    A = dice[0]
    B = cell[ni][nj]
    # print("이동 방향", direction)
    # print("이동 후 아래면", A)
    # print("이동위치", ni, nj)
    # 이동방향 처리
    if A > B:
        direction = (direction + 1) % 4
    elif A < B:
        direction = (direction + 3) % 4

    answer += getPoint(ni, nj, cell[ni][nj])
    ci = ni
    cj = nj

print(answer)
# (1,1)에서 시작

# 이동방향으로 이동 (벽에 막히면 반대방향)

# 도착칸(x, y)의점수 획득
# (x, y)에와 같은 숫자 연결 수

# 아랫면A와 도착점 B의 크기로 방향 결정
# A>B 90도 시계반향
# A<B 90도 반시계
# A=B 유지

#      E W S N
# 밑 6 3 4 5 2
# 위 1 4 3 2 5
# 동 3 1 6 3 3
# 서 4 6 1 4 4
# 앞 5 5 5 1 6
# 뒤 2 2 2 6 1
