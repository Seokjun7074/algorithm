import sys

input = sys.stdin.readline


def find_num_position(num):
    for i in range(N):
        for j in range(N):
            if len(cell[i][j]) > 0 and cell[i][j][0][0] == num:
                return i, j, cell[i][j][0][1]
    return None


def move_to_white(y, x, num, ny, nx, d):
    for n, direction in cell[y][x]:
        cell[ny][nx].append([n, direction])
    check_game_over(len(cell[ny][nx]))
    cell[y][x] = []
    return


def move_to_red(y, x, num, ny, nx, d):
    for n, direction in cell[y][x][::-1]:
        cell[ny][nx].append([n, direction])
    check_game_over(len(cell[ny][nx]))
    cell[y][x] = []
    return


def move_to_blue(y, x, num, ny, nx, d):
    d = reverseDirection(d)
    cell[y][x][0][1] = d
    ny = y + dy[d]
    nx = x + dx[d]
    if 0 <= ny < N and 0 <= nx < N:
        if color_map[ny][nx] == 0:
            move_to_white(y, x, num, ny, nx, d)
        elif color_map[ny][nx] == 1:
            move_to_red(y, x, num, ny, nx, d)
    return


def reverseDirection(d):
    if d == 0:
        return 1
    elif d == 1:
        return 0
    elif d == 2:
        return 3
    elif d == 3:
        return 2


def check_game_over(l):
    global GAME_OVER
    if l >= 4:
        GAME_OVER = True


# 오 왼 위 아래
dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]

N, K = map(int, input().split())
color_map = [list(map(int, input().split())) for _ in range(N)]
cell = [[[] for _ in range(N)] for _ in range(N)]

for n in range(1, K + 1):
    i, j, d = map(int, input().split())
    cell[i - 1][j - 1].append([n, d - 1])  # 번호, 방향

T = 1
answer = -1
GAME_OVER = False

while T <= 1000:
    for num in range(1, K + 1):
        if not find_num_position(num):
            continue
        y, x, d = find_num_position(num)
        ny = y + dy[d]
        nx = x + dx[d]
        # 범위 안에 있는 경우
        if 0 <= ny < N and 0 <= nx < N:
            if color_map[ny][nx] == 0:
                move_to_white(y, x, num, ny, nx, d)
            elif color_map[ny][nx] == 1:
                move_to_red(y, x, num, ny, nx, d)
            elif color_map[ny][nx] == 2:
                move_to_blue(y, x, num, ny, nx, d)
        # 범위 밖에 있는 경우
        else:
            move_to_blue(y, x, num, ny, nx, d)
    # for z in cell:
    #     print(z)
    if GAME_OVER:
        answer = T
        break
    T += 1
print(answer)
# 1번부터 k번까지 순서대로 이동
# 겹쳐져있으면 아래에 있는것만 이동
# 1. 이동하려는 칸이 흰색
#   이동하려는 칸에 말이 있으면 그 말 위에 올림
# 2. 빨간색인 경우
#   이동 후 대상의 순서 역순으로 변경
# 3. 파란색
#   반대방향으로 이동
# 4. 범위 밖
#   반대방향으로 이동
# 말이 4개 이상 쌓인다면 종료
