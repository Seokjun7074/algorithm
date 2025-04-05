import sys
from collections import deque
sys.stdin = open("../input.txt")
input = sys.stdin.readline


N, M, K = map(int, input().split())
cell = [list(map(int, input().split())) for _ in range(N)]
checkAttack = [[0] * M for _ in range(N)]


def findAttacker():
    attackerList = []
    minpower = float('inf')
    for i in range(N):
        for j in range(M):
            if cell[i][j] > 0:
                minpower = min(cell[i][j], minpower)
    for i in range(N):
        for j in range(M):
            if cell[i][j] == minpower:
                attackerList.append((minpower, checkAttack[i][j], i, j))
    attackerList.sort(key=lambda x: (-x[1], -(x[2] + x[3]), -x[3]))
    return [attackerList[0][2], attackerList[0][3]]


def findTarget():
    targetList = []
    maxpower = -float('inf')
    for i in range(N):
        for j in range(M):
            maxpower = max(cell[i][j], maxpower)
    for i in range(N):
        for j in range(M):
            if cell[i][j] == maxpower:
                targetList.append((maxpower, checkAttack[i][j], i, j))
    targetList.sort(key=lambda x: (x[1], (x[2] + x[3]), x[3]))
    return [targetList[0][2], targetList[0][3]]


def lazer(start, end):
    dy = [0, 1, 0, -1]
    dx = [1, 0, -1, 0]
    v = [[False] * M for _ in range(N)]
    q = deque()
    si, sj = start
    ei, ej = end
    q.append((si, sj, []))
    v[si][sj] = True

    while q:
        curI, curJ, path = q.popleft()
        for d in range(4):
            ni = (curI + dy[d]) % N
            nj = (curJ + dx[d]) % M
            if cell[ni][nj] == 0 or v[ni][nj]:
                continue
            newPath = path + [(ni, nj)]
            if ni == ei and nj == ej:
                return True, path
            v[ni][nj] = True
            q.append((ni, nj, newPath))
    return False, []


def bomb(start, end):
    si, sj = start
    ei, ej = end
    dy = [0, 1, 0, -1, -1, 1, -1, 1]
    dx = [1, 0, -1, 0, -1, 1, 1, -1]
    path = []
    for d in range(8):
        ni = (ei + dy[d]) % N
        nj = (ej + dx[d]) % M
        if cell[ni][nj] == 0 or (ni, nj) == (si, sj):
            continue
        path.append((ni, nj))
    return path


def repair(start, end, dmg):
    for i in range(N):
        for j in range(M):
            if cell[i][j] > 0 and [i, j] != start and [i, j] != end and (i, j) not in dmg:
                cell[i][j] += 1


def checkFinish():
    cnt = 0
    for i in range(N):
        for j in range(M):
            if cell[i][j] > 0:
                cnt += 1
                if cnt > 1:
                    return False
    return True


for seq in range(1, K + 1):
    attacker = findAttacker()
    target = findTarget()
    checkAttack[attacker[0]][attacker[1]] = seq
    cell[attacker[0]][attacker[1]] += (N + M)

    is_lazer, path = lazer(attacker, target)
    dmgList = []

    if is_lazer:
        cell[target[0]][target[1]] -= cell[attacker[0]][attacker[1]]
        for i, j in path:
            dmgList.append((i, j))
            dmg = cell[i][j] - (cell[attacker[0]][attacker[1]] // 2)
            cell[i][j] = max(dmg, 0)
    else:
        path = bomb(attacker, target)
        cell[target[0]][target[1]] -= cell[attacker[0]][attacker[1]]
        for i, j in path:
            dmgList.append((i, j))
            dmg = cell[i][j] - (cell[attacker[0]][attacker[1]] // 2)
            cell[i][j] = max(dmg, 0)

    repair(attacker, target, dmgList)

    if checkFinish():
        break

answer = 0
for x in cell:
    answer = max(answer, max(x))
print(answer)

# 종료조건 1개빼고 다 부수기

# 1. 공격자 선정
# 가장 약한 포탑 -> N*M 만큼 보너스 공격력 제공

# 약한 포탑 선정 기준
# 공격력 낮은거 -> 최근에 공격한거(checkAttack값 큰거) -> 위치(i, j)의 합이 가장 큰거 -> 열(i)이 가장 큰거

# 2. 공격 시퀸스
# 공격자 빼고 가장 센 포탑 공격

# 센 포탑 선정 기준
# 공격력 높은거 -> 오래전에 공격한거 -> 위치(i, j)의 합이 가장 작은거 -> 열(i)이 가장 작은거


# 레이저 공격
# 상하좌우
# 부숴진 자리는 이동 X
# 벽 만나면 반대편으로  이동
# 공격자에서 대상까지 최단 경로로 공격 (우/하/좌/상 순서대로)
# 공격 받으면 공격력 만큼 까이고 최단 경로에 있는 애들은 절반만큼 까임


# 포탄 공격
# 주위 8방향에 절반만큼 데미지(공격자는 영향 X)
# 벽 만나면 반대편으로 넘어감

# 3. 정비
# 공격 이후 공격 안받은애들 1씩 증가
