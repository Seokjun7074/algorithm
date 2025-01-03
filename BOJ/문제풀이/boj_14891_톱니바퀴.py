import sys
from collections import deque

input = sys.stdin.readline
gear = []

for _ in range(4):
    g = list(input().rstrip())
    gear.append(list(map(int, g)))
K = int(input())

# 2번, 6번 인덱스가 접점

for _ in range(K):
    # 1 = 시계, -1 = 반시계
    target, head = map(int, input().split())
    left = gear[target - 1][2]
    right = gear[target - 1][6]
    rotate = [target - 1]
    # 타겟 기준 왼쪽
    for x in range(target - 1, 0, -1):
        curLeft = gear[x][6]
        beforRight = gear[x - 1][2]
        if curLeft != beforRight:
            rotate.append(x - 1)
        else:
            break
    for x in range(target - 1, 3):
        curRight = gear[x][2]
        nextLeft = gear[x + 1][6]
        if curRight != nextLeft:
            rotate.append(x + 1)
        else:
            break
    for x in rotate:
        # 타겟과 같이 회전하는 경우
        if (target - 1) % 2 == x % 2:
            if head == 1:
                tmp = gear[x].pop()
                gear[x].insert(0, tmp)
            else:
                tmp = gear[x].pop(0)
                gear[x].append(tmp)
        # 타겟과 반대로 회전하는 경우
        else:
            if head == -1:
                tmp = gear[x].pop()
                gear[x].insert(0, tmp)
            else:
                tmp = gear[x].pop(0)
                gear[x].append(tmp)
result = 0
for x in range(4):
    if gear[x][0] == 1:
        result += 2**x
print(result)
