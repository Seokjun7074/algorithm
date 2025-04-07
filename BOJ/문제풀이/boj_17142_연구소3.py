import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
g = [list(map(int, input().split())) for _ in range(N)]


virus = []
for i in range(N):
    for j in range(N):
        if g[i][j] == 2:
            virus.append((i, j))


def combination(arr, r):
    comb = []

    def generate(idx, tmp):
        if len(tmp) == r:
            comb.append(list(tmp))
            return

        for i in range(idx, len(arr)):
            tmp.append(arr[i])
            generate(i + 1, tmp)
            tmp.pop()

    generate(0, [])
    return comb


dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
answer = float("inf")
for arr in combination(virus, M):
    v = [[-1] * N for _ in range(N)]
    q = deque()
    for i, j in arr:
        q.append((i, j, 0))
        v[i][j] += 1

    while q:
        ci, cj, cnt = q.popleft()
        for d in range(4):
            ni = ci + dy[d]
            nj = cj + dx[d]
            # 못가는 길
            if (
                ni < 0
                or ni >= N
                or nj < 0
                or nj >= N
                or g[ni][nj] == 1
                or v[ni][nj] > -1
            ):
                continue

            if v[ni][nj] == -1:
                v[ni][nj] = cnt + 1
                q.append((ni, nj, cnt + 1))
            else:
                if v[ni][nj] > cnt + 1:
                    v[ni][nj] = cnt + 1
                    q.append((ni, nj, cnt + 1))
    # 원래 있던 바이러스 처리
    for i, j in virus:
        v[i][j] = 0

    # 전체 다 감염됐는지 확인
    isPossible = True
    for i in range(N):
        if not isPossible:
            break
        for j in range(N):
            if g[i][j] == 0 and v[i][j] == -1:
                isPossible = False
                break
    if not isPossible:
        continue

    # 감염시간 계산
    vm = -1
    for i in range(N):
        vm = max(max(v[i]), vm)
    answer = min(answer, vm)
if answer == float("inf"):
    print(-1)
else:
    print(answer)
