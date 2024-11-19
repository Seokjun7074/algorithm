import sys, heapq

input = sys.stdin.readline
N = int(input())
arr = []

for _ in range(N):
    num = int(input())
    if num == 0:
        if len(arr) == 0:
            print(0)
        else:
            k = heapq.heappop(arr)
            print(k[1])
    else:
        heapq.heappush(arr, (abs(num), num))
