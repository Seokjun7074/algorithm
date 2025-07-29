import sys
from collections import deque

dy = [1, -1, 0, 0]
dx = [0, 0, -1, 1]


def solution(board):
    answer = sys.maxsize
    H = len(board)
    W = len(board[0])

    si, sj = 0, 0
    ei, ej = 0, 0
    for i in range(H):
        for j in range(W):
            if board[i][j] == "R":
                si = i
                sj = j
            if board[i][j] == "G":
                ei = i
                ej = j

    q = deque()
    q.append((si, sj, -1, 0))  # i,j,방향,cnt
    visited = [[False] * W for _ in range(H)]
    visited[si][sj] = True
    while q:
        ci, cj, cd, cnt = q.popleft()
        if ci == ei and cj == ej:
            answer = min(answer, cnt)

        for d in range(4):
            if d == cd:
                continue
            ni, nj = ci, cj
            while True:
                nni = ni + dy[d]
                nnj = nj + dx[d]

                if not (0 <= nni < H and 0 <= nnj < W):
                    break
                if board[nni][nnj] == "D":
                    break
                ni, nj = nni, nnj

            if (ni != ci or nj != cj) and not visited[ni][nj]:
                visited[ni][nj] = True
                q.append((ni, nj, d, cnt + 1))

    if answer == sys.maxsize:
        return -1
    return answer
