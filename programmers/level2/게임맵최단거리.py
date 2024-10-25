from collections import deque


def solution(maps):
    q = deque()
    N = len(maps)
    M = len(maps[0])
    answer = -1

    v = [[False] * M for _ in range(N)]
    v[0][0] = True
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    start = [0, 0]
    end = [N - 1, M - 1]
    q.append([start, v, 1])

    while q:
        cur = q.popleft()
        curX, curY = cur[0]
        curV = cur[1]
        curCnt = cur[2]
        if curX == N - 1 and curY == M - 1:
            return curCnt
        for i in range(4):
            nx = curX + dx[i]
            ny = curY + dy[i]
            if (
                0 <= nx < N
                and 0 <= ny < M
                and curV[nx][ny] == False
                and maps[nx][ny] == 1
            ):
                curV[nx][ny] = True
                q.append([[nx, ny], curV, curCnt + 1])

    return answer
