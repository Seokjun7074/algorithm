from collections import deque
import sys

sys.stdin = open("../input.txt")
input = sys.stdin.readline


def rotate(si, sj, arr):
    new_arr = [x[:] for x in arr]
    for i in range(3):
        for j in range(3):
            new_arr[si + i][sj + j] = arr[si + 2 - j][sj + i]
    return new_arr


def bfs(si, sj, v, arr, isReset):
    q = deque([(si, sj)])
    v[si][sj] = 1
    visitedSet = set()
    visitedSet.add((si, sj))
    cnt = 1
    while q:
        ci, cj = q.popleft()
        for di, dj in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            ni = ci + di
            nj = cj + dj
            if (
                0 <= ni < 5
                and 0 <= nj < 5
                and v[ni][nj] == 0
                and arr[ni][nj] == arr[ci][cj]
            ):
                v[ni][nj] = 1
                q.append((ni, nj))
                visitedSet.add((ni, nj))
                cnt += 1
    if cnt >= 3:
        if isReset:
            for i, j in visitedSet:
                arr[i][j] = 0
        return cnt
    return 0


# arr 대상으로 보물찾기
def findTreasure(arr, isReset):
    v = [[0] * 5 for _ in range(5)]
    cnt = 0
    for i in range(5):
        for j in range(5):
            # 각 좌표를 돌며 같은놈 BFS 탐색
            cnt += bfs(i, j, v, arr, isReset)
    return cnt


K, M = map(int, input().split())
cell = [list(map(int, input().split())) for _ in range(5)]
lst = list(map(int, input().split()))
refill_list = deque(lst)
result = []

# findTreasure(rotate(1,1,cell))
for _ in range(K):  # K턴을 진행(유물이 없는 경우 즉시종료)
    first_price = 0
    target_arr = None  # 첫번째 탐색 이후에 지정한 배열
    for angle in range(1, 4):
        for j in range(3):
            for i in range(3):
                # 회전시키기
                new_arr = [x[:] for x in cell]
                for _ in range(angle):
                    new_arr = rotate(i, j, new_arr)
                # 회전된 배열 대상으로 보물 찾기
                t = findTreasure(new_arr, False)
                if first_price < t:
                    target_arr = new_arr
                    first_price = t
    # 찾은게 없으면 종료
    if first_price == 0 or not target_arr:
        break
    # 반복 돌리기
    answer = 0
    cell = target_arr
    while True:
        t = findTreasure(cell, True)
        if t == 0:
            break
        answer += t
        for j in range(5):
            for i in range(4, -1, -1):
                if cell[i][j] == 0:
                    new_num = refill_list.popleft()
                    cell[i][j] = new_num
    result.append(answer)
print(*result)
