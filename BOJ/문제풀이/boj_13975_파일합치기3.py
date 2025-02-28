import sys, heapq

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    answer = 0
    K = int(input())
    pq = sorted(list(map(int, input().split())))

    while pq:
        if len(pq) < 2:
            break
        num1 = heapq.heappop(pq)
        num2 = heapq.heappop(pq)
        s = num1 + num2
        answer += s
        heapq.heappush(pq, s)
    print(answer)
