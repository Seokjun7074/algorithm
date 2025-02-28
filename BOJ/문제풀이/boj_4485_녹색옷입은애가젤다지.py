import sys, heapq

input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
problem = 1
while True:
    N = int(input())
    # 종료 조건
    if N == 0:
        break
    g = []
    v = [[sys.maxsize] * N for _ in range(N)]
    for _ in range(N):
        g.append(list(map(int, input().split())))
    pq = [(g[0][0], 0, 0)]  # (도둑, i, j)
    v[0][0] = g[0][0]

    while pq:
        cost, i, j = heapq.heappop(pq)
        # 탐색 종료
        if i == N - 1 and j == N - 1:
            break
        for d in range(4):
            ni = i + dx[d]
            nj = j + dy[d]
            if ni >= N or ni < 0 or nj >= N or nj < 0:
                continue
            newCost = cost + g[ni][nj]
            if newCost < v[ni][nj]:
                v[ni][nj] = newCost
                heapq.heappush(pq, (newCost, ni, nj))
    result = "Problem " + str(problem) + ": " + str(v[N - 1][N - 1])
    print(result)
    problem += 1
