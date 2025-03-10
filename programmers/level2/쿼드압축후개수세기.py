def checkNum(arr, x, y, n):
    for i in range(x, x + n):
        for j in range(y, y + n):
            if arr[i][j] != arr[x][y]:
                n //= 2
                checkNum(arr, x, y, n)
                checkNum(arr, x + n, y, n)
                checkNum(arr, x, y + n, n)
                checkNum(arr, x + n, y + n, n)
                return
    answer[arr[x][y]] += 1


def solution(arr):
    global answer
    answer = [0, 0]
    checkNum(arr, 0, 0, len(arr))

    return answer
