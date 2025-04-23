import heapq

answer = 0
N = int(input())
pq = []

for _ in range(N):
    pq.append(int(input()))

heapq.heapify(pq)


while len(pq) > 1:
    n1 = heapq.heappop(pq)
    n2 = heapq.heappop(pq)
    s = n1 + n2
    heapq.heappush(pq, s)
    answer += s
print(answer)
