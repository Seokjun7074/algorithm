import sys
from collections import deque

input = sys.stdin.readline
N, K = map(int, input().split())
belt = list(map(int, input().split()))
robot = [False] * (N * 2)

step = 0

while True:
    step += 1

    # 1. 회전
    belt.insert(0, belt.pop())
    robot.insert(0, robot.pop())
    robot[N - 1] = False  # 내리는 위치

    # 2. 로봇 이동
    for i in range(N - 2, -1, -1):  # N-2부터 0까지
        if robot[i] and not robot[i + 1] and belt[i + 1] > 0:
            robot[i] = False
            robot[i + 1] = True
            belt[i + 1] -= 1
    robot[N - 1] = False  # 내리는 위치

    # 3. 로봇 올리기
    if belt[0] > 0 and not robot[0]:
        robot[0] = True
        belt[0] -= 1

    # 4. 종료조건
    if belt.count(0) >= K:
        break

print(step)
