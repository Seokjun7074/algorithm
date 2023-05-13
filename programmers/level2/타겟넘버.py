from collections import deque

q1 = deque()


def solution(numbers, target):
    return bfs(numbers, 0, target)


def bfs(numbers, cnt, target):
    q1.append([numbers[0], cnt])
    q1.append([-numbers[0], cnt])
    count = 0
    while q1:
        cur = q1.popleft()
        curNumber = cur[0]
        curCnt = cur[1]
        if curCnt == len(numbers) - 1 and curNumber == target:
            count += 1

        if curCnt + 1 < len(numbers):
            q1.append([curNumber + numbers[curCnt + 1], curCnt + 1])
            q1.append([curNumber - numbers[curCnt + 1], curCnt + 1])
    return count


solution([1, 1, 1, 1, 1], 3)
