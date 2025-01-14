from collections import deque


def solution(land):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    N = len(land)  # 세로
    M = len(land[0])  # 가로
    visited = [[False] * M for _ in range(N)]
    oilArr = [0] * M

    for x in range(M):
        for y in range(N):
            position = []
            if land[y][x] == 1 and not visited[y][x]:
                q = deque()
                cnt = 0
                q.append([y, x, 0])
                position.append(x)
                visited[y][x] = True
                cnt += 1
                while q:
                    curY, curX, curCnt = q.popleft()
                    for k in range(4):
                        ny = curY + dy[k]
                        nx = curX + dx[k]
                        if (
                            0 <= ny < N
                            and 0 <= nx < M
                            and land[ny][nx] == 1
                            and not visited[ny][nx]
                        ):
                            q.append([ny, nx, curCnt + 1])
                            position.append(nx)
                            visited[ny][nx] = True
                            cnt += 1
                for i in set(position):
                    oilArr[i] += cnt
    return max(oilArr)
