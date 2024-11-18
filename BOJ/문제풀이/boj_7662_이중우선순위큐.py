import sys
import heapq

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    k = int(input())
    min_hq = []  # 최소 힙
    max_hq = []  # 최대 힙
    visited = [False] * k  # 삭제 상태를 추적하기 위한 리스트
    for i in range(k):
        command, num = input().split()
        num = int(num)
        if command == "I":
            # 최소 힙과 최대 힙에 각각 삽입
            heapq.heappush(min_hq, (num, i))
            heapq.heappush(max_hq, (-num, i))
            visited[i] = True
        elif command == "D":
            if num == -1:  # 최솟값 삭제
                while min_hq and not visited[min_hq[0][1]]:
                    heapq.heappop(min_hq)  # 이미 삭제된 값은 스킵
                if min_hq:
                    visited[min_hq[0][1]] = False
                    heapq.heappop(min_hq)
            else:  # 최댓값 삭제
                while max_hq and not visited[max_hq[0][1]]:
                    heapq.heappop(max_hq)  # 이미 삭제된 값은 스킵
                if max_hq:
                    visited[max_hq[0][1]] = False
                    heapq.heappop(max_hq)

    # 결과 출력
    while min_hq and not visited[min_hq[0][1]]:
        heapq.heappop(min_hq)
    while max_hq and not visited[max_hq[0][1]]:
        heapq.heappop(max_hq)

    if not min_hq:
        print("EMPTY")
    else:
        print(-max_hq[0][0], min_hq[0][0])
