def head_idx(arr):
    for i in range(n):
        for j in range(n):
            if arr[i][j] == "*":
                return i, j


def left_arm(y, x):
    cnt = 0
    for i in range(x - 1, -1, -1):
        cnt += 1
        if arr[y][i] == "_":
            return cnt - 1
    return cnt


def right_arm(y, x):
    cnt = 0
    for i in range(x + 1, n, 1):
        cnt += 1
        if arr[y][i] == "_":
            return cnt - 1
    return cnt


def body(y, x):
    cnt = 0
    for i in range(y, n):
        cnt += 1
        if arr[i][x] == "_":
            break
    return cnt - 1


def leg(y, x):
    cnt = 1
    for i in range(y, n):
        if arr[i][x] == "_":
            break
        cnt += 1
    return cnt - 1


n = int(input())
arr = []
for _ in range(n):
    row = input()
    arr.append(list(row))

y, x = head_idx(arr)
print(y + 2, x + 1)
print(left_arm(y + 1, x), end=" ")
print(right_arm(y + 1, x), end=" ")
print(body(y + 2, x), end=" ")
print(leg(y + body(y + 2, x) + 2, x - 1), end=" ")
print(leg(y + body(y + 2, x) + 2, x + 1), end=" ")
