import heapq


def solution(operations):
    answer = []
    dic = dict()
    maxQ = []
    minQ = []
    for input in operations:
        cmd, num = map(str, input.split(" "))
        num = int(num)
        if cmd == "I":
            heapq.heappush(minQ, num)
            heapq.heappush(maxQ, -num)
            # 딕셔너리 추가
            if num in dic:
                dic[num] += 1
            else:
                dic[num] = 1
        if cmd == "D" and len(minQ) > 0 and len(maxQ) > 0:
            if num == 1:
                # 최대값 삭제
                maxNum = heapq.heappop(maxQ)
                while maxQ:
                    if dic[(-1 * maxNum)] > 0:
                        break
                    maxNum = heapq.heappop(maxQ)
                dic[(-1 * maxNum)] -= 1
            else:
                # 최솟값 삭제
                minNum = heapq.heappop(minQ)
                while minQ:
                    if dic[minNum] > 0:
                        break
                    minNum = heapq.heappop(minQ)
                dic[minNum] -= 1
    finalArr = []
    for x in dic:
        if dic[x] > 0:
            finalArr.append(x)
    if len(finalArr) > 0:
        return [max(finalArr), min(finalArr)]
    return [0, 0]
