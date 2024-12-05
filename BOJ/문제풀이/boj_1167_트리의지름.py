import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
tree = [[] for _ in range(N + 1)]

for _ in range(N):
    li = list(map(int, input().split()))
    node = li[0]
    for i in range(1, len(li) - 1, 2):  # 마지막 -1 제외
        tree[node].append((li[i], li[i + 1]))


def bfs(start):
    visited = [-1] * (N + 1)  # 방문 여부 및 거리
    queue = deque([(start, 0)])
    visited[start] = 0
    farthest_node = (0, 0)  # (거리, 노드)

    while queue:
        current, dist = queue.popleft()
        for next_node, weight in tree[current]:
            if visited[next_node] == -1:  # 방문하지 않은 노드
                visited[next_node] = dist + weight
                queue.append((next_node, dist + weight))
                if visited[next_node] > farthest_node[0]:
                    farthest_node = (visited[next_node], next_node)

    return farthest_node


# 트리의 지름 계산
# 1. 임의의 노드에서 가장 먼 노드 찾기
_, farthest = bfs(1)

# 2. 그 노드에서 가장 먼 노드까지의 거리 구하기
diameter, _ = bfs(farthest)
print(diameter)
