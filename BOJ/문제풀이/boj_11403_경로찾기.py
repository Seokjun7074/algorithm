import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
answer = [[0] * n for _ in range(n)]


def bfs(start):
    q = deque()
    q.append(start)
    visited = [0] * n

    while q:
        cur = q.popleft()
        for x in range(n):
            if visited[x] == 0 and graph[cur][x] == 1:
                visited[x] = 1
                q.append(x)
                answer[start][x] = 1


for x in range(n):
    bfs(x)


for x in answer:
    print(*x)
