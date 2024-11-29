import sys

input = sys.stdin.readline

sudoku = []
blank = []
for i in range(9):
    sudoku.append(list(map(int, input().split())))
    for j in range(9):
        if sudoku[i][j] == 0:
            blank.append([i, j])


def row(i, step):
    if step in sudoku[i]:
        return False
    return True


def column(j, step):
    for i in range(9):
        if step == sudoku[i][j]:
            return False
    return True


def square(y, x, step):
    for i in range(3):
        for j in range(3):
            if step == sudoku[y // 3 * 3 + i][x // 3 * 3 + j]:
                return False
    return True


def dfs(n):
    if n == len(blank):
        for x in sudoku:
            print(*x)
        exit()

    for i in range(1, 10):
        y = blank[n][0]
        x = blank[n][1]
        if column(x, i) and row(y, i) and square(y, x, i):
            sudoku[y][x] = i
            dfs(n + 1)
            sudoku[y][x] = 0


dfs(0)
