from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def findPiece(data, target):
    pieces = []
    N = len(data)
    v = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if data[i][j] == target:
                if v[i][j]:
                    continue
                v[i][j] = True
                q = deque()
                q.append((i, j))
                pieceData = [(i, j)]
                while q:
                    ci, cj = q.popleft()
                    for d in range(4):
                        ni = ci + dy[d]
                        nj = cj + dx[d]
                        if (
                            0 <= ni < N
                            and 0 <= nj < N
                            and data[ni][nj] == target
                            and not v[ni][nj]
                        ):
                            v[ni][nj] = True
                            q.append((ni, nj))
                            pieceData.append((ni, nj))
                pieces.append(pieceData)
    return pieces


def makeBounding(data):
    y = [i[0] for i in data]
    x = [i[1] for i in data]

    height, width = max(y) - min(y) + 1, max(x) - min(x) + 1
    bounding = [[0] * width for _ in range(height)]
    move_i = min(y)
    move_j = min(x)

    for i, j in data:
        bounding[i - move_i][j - move_j] = 1

    return bounding


def rotate(data):
    height, width = len(data), len(data[0])
    # 직사각형을 회전하면 눕는거 반영
    rotated = [[0] * height for _ in range(width)]
    count = 0
    for i in range(height):
        for j in range(width):
            if data[i][j] == 1:
                count += 1
            rotated[j][height - 1 - i] = data[i][j]

    return rotated, count


def solution(game_board, table):
    answer = 0
    # 1. 조각찾기
    blanks = findPiece(game_board, 0)
    pieces = findPiece(table, 1)
    used_idx = [False] * len(pieces)
    # 2. 일반화하기(사각형 사이즈로)
    # 3. 찾기
    for blank in blanks:
        bounded_blank = makeBounding(blank)
        done = False
        for idx, piece in enumerate(pieces):
            if used_idx[idx]:
                continue
            if done:
                break
            bounded_piece = makeBounding(piece)
            # 회전시키면서 비교
            for _ in range(4):
                bounded_piece, cnt = rotate(bounded_piece)
                if bounded_piece == bounded_blank:
                    done = True
                    answer += cnt
                    used_idx[idx] = True
                    break
    return answer
