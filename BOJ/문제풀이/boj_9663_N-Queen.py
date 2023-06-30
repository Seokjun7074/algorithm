n = int(input())
arr = [0] * n
cnt = 0


def det(num):
    for v in range(num):
        if arr[num] == arr[v] or abs(arr[num] - arr[v]) == num - v:
            return 0
    return 1


def func(num):
    global cnt

    if num == n:
        cnt += 1
        return

    for i in range(n):
        arr[num] = i
        if det(num):
            func(num + 1)


func(0)
print(cnt)
