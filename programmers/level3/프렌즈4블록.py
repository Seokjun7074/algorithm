dy = [1, 1, 0]
dx = [0, 1, 1]


def pang(si, sj, board, M, N):
    startBlock = board[si][sj]
    cnt = 1
    for d in range(3):
        ni = si + dy[d]
        nj = sj + dx[d]
        if not (0 <= ni < M and 0 <= nj < N):
            return False
        if board[ni][nj] != startBlock:
            return False
        else:
            cnt += 1
    if cnt == 4:
        return True
    return False


def setVisited(si, sj, v):
    v[si][sj] = True
    for d in range(3):
        ni = si + dy[d]
        nj = sj + dx[d]
        v[ni][nj] = True
    return v


def countVisited(v, m, n):
    cnt = 0
    for i in range(m):
        for j in range(n):
            if v[i][j]:
                cnt += 1
    return cnt


def setBlankBoard(board, v, m, n):
    for i in range(m):
        for j in range(n):
            if v[i][j]:
                board[i][j] = "*"
    return board


def down(board, m, n):
    for j in range(n):
        q = []
        blank_cnt = 0
        for i in range(m):
            if board[i][j] == "*":
                blank_cnt += 1
                continue
            q.append(board[i][j])

        q = (["*"] * blank_cnt) + q
        for i in range(m):
            board[i][j] = q[i]
    return board


def solution(m, n, board):
    board = [list(board[i]) for i in range(m)]
    answer = 0
    isFinished = False

    while True:
        if isFinished:
            break
        visited = [[False] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if board[i][j] == "*":
                    continue
                pang_result = pang(i, j, board, m, n)
                if pang_result:
                    visited = setVisited(i, j, visited)
        v_cnt = countVisited(visited, m, n)
        answer += v_cnt
        if v_cnt == 0:
            isFinished = True
        board = setBlankBoard(board, visited, m, n)
        board = down(board, m, n)

    return answer


# 지워지는거 표시
# 내리기
# 반복

# "CCBDE"
# "AAADE"
# "AAABF"
# "CCBBF"

# "TTTANT"
# "RRFACC"
# "RRRFCC"
# "TRRRAA"
# "TTMMMF"
# "TMMTTJ"
