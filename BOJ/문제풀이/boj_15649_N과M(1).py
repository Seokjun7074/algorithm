N, M = map(int, input().split())

v = [False] * (N + 1)
arr = []
# for i in range(1, N + 1):
#     arr.append(i)


def perm(cnt):
    if cnt == M:
        print(" ".join(map(str, arr)))
        return
    for i in range(1, N + 1):
        if v[i] == True:
            continue
        v[i] = True
        arr.append(i)
        perm(cnt + 1)
        v[i] = False
        arr.pop()


perm(0)
