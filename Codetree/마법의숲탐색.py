from collections import deque
import sys

sys.stdin = open("../input.txt")
input = sys.stdin.readline


def add_golem(center_i, center_j, exitD, forest, golem_id):
    forest[center_i][center_j] = golem_id
    for d in range(4):
        ni = center_i + di[d]
        nj = center_j + dj[d]
        if exitD == d:
            forest[ni][nj] = -golem_id
        else:
            forest[ni][nj] = golem_id
    return forest


def can_place(ci, cj):
    # 골렘의 중심이 (ci, cj)에 놓일 수 있는지 확인
    if ci + 1 >= R + 3 or cj - 1 < 0 or cj + 1 >= C:
        return False
    if forest[ci - 1][cj - 1] != 0:
        return False
    if forest[ci - 1][cj] != 0:
        return False
    if forest[ci - 1][cj + 1] != 0:
        return False
    if forest[ci][cj - 1] != 0:
        return False
    if forest[ci][cj] != 0:
        return False
    if forest[ci][cj + 1] != 0:
        return False
    if forest[ci + 1][cj] != 0:
        return False
    return True


def move_golem(si, sj, sd):
    ci, cj = si, sj
    while True:
        # 아래로 갈 수 있으면 아래로
        if can_place(ci + 1, cj):
            ci += 1
        # 왼쪽 아래로 회전 가능
        elif can_place(ci + 1, cj - 1):
            ci += 1
            cj -= 1
            sd = (sd + 3) % 4
        # 오른쪽 아래로 회전 가능
        elif can_place(ci + 1, cj + 1):
            ci += 1
            cj += 1
            sd = (sd + 1) % 4
        else:
            # 정착도 안 되고 숲 범위를 벗어나는 경우
            if not (4 <= ci < R + 2 and 1 <= cj < C - 1):
                return (-1, -1, -1)
            # 여기서 정착
            return (ci, cj, sd)


def move_fairy(destination_i, destination_j, forest):
    fairy_bottom = 0  # 요정의 초대 남하 i값
    q = deque([(destination_i, destination_j)])
    v = [[0] * C for _ in range(R + 3)]
    v[destination_i][destination_j] = 1

    while q:
        ci, cj = q.popleft()
        if ci > fairy_bottom:
            fairy_bottom = ci
        for d in range(4):
            ni = ci + di[d]
            nj = cj + dj[d]
            if (
                0 <= ni < R + 3
                and 0 <= nj < C
                and v[ni][nj] == 0
                and forest[ni][nj] != 0
            ):
                # 현재 위치가 출구인 경우
                if forest[ci][cj] < 0:
                    v[ni][nj] = 1
                    q.append((ni, nj))
                # 출구가 아니라서 현재 골렘에서만 이동 가능
                else:
                    if abs(forest[ni][nj]) == forest[ci][cj]:
                        v[ni][nj] = 1
                        q.append((ni, nj))

    return fairy_bottom - 2


R, C, K = map(int, input().split())
forest = [[0] * C for _ in range(R + 3)]  # 숲 영역 밖에 있는 경우
# exit_map = [[0]*C for _ in range(R+3)] # 출구만 표시
#     북-동-남-서
di = [-1, 0, 1, 0]
dj = [0, 1, 0, -1]
answer = 0
for golem_id in range(1, K + 1):  # 정령 수 만큼 반복
    # 출발 열, 탈출구 방향
    sc, sd = map(int, input().split())
    sc -= 1  # 좌표 보정
    # 입력받은 골렘을 남하
    destination_i, destination_j, exitD = move_golem(
        1, sc, sd
    )  # 제일 하단의 중앙좌표, 출구 방향
    # print()
    # print(destination_i, destination_j, exitD)

    # 범위 초과해서 초기화
    if exitD == -1:
        forest = [[0] * C for _ in range(R + 3)]
        # exit_map = [[0] * C for _ in range(R + 3)]
        continue
    else:
        forest = add_golem(destination_i, destination_j, exitD, forest, golem_id)
        # for z in forest[3:]:
        #     print(*z)
        result = move_fairy(
            destination_i, destination_j, forest
        )  # 요정이 골렘 타고 남하
        # print(result)
        answer += result


print(answer)
