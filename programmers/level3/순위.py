def solution(n, results):
    answer = 0
    g = [[0] * (n + 1) for _ in range(n + 1)]
    for i, j in results:
        g[i][j] = 1
        g[j][i] = -1

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if i == j:
                    continue
                if g[i][k] == 1 and g[k][j] == 1:
                    g[i][j] = 1
                    g[j][i] = -1

    for line in g:
        zero = 0
        for i in range(1, n + 1):
            if line[i] == 0:
                zero += 1
        if zero == 1:
            answer += 1
    return answer
