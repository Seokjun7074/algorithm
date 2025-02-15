import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
cntNode = [0] * (N + 1)  # 진입 차수 저장
node = [[] for _ in range(N + 1)]  # 노드정보
answer = []

for _ in range(M):
    start, end = map(int, input().split())
    cntNode[end] += 1
    node[start].append(end)
q = deque()
for i in range(1, N + 1):
    if cntNode[i] == 0:
        q.append(i)

while q:
    curNode = q.popleft()
    for nextNode in node[curNode]:
        cntNode[nextNode] -= 1  # curNode와 연결된 노드 간선 제거
        if cntNode[nextNode] == 0:  # 다 끊긴 노드가 된다면 큐에 추가
            q.append(nextNode)
    answer.append(curNode)
for x in answer:
    print(x, end=" ")
