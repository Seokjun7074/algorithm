answer = 0


def dfs(k, cnt, dungeons, v):
    global answer
    answer = max(answer, cnt)
    for i in range(len(dungeons)):
        if v[i] or k < dungeons[i][0]:
            continue
        v[i] = True
        dfs(k - dungeons[i][1], cnt + 1, dungeons, v)
        v[i] = False


def solution(k, dungeons):
    v = [False] * len(dungeons)
    dfs(k, 0, dungeons, v)
    return answer
