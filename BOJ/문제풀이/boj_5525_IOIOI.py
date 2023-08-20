import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
S = input()

position, cnt, result = 0, 0, 0

while position < (M - 1):
    if S[position : position + 3] == "IOI":  # 3칸
        cnt += 1
        position += 2
        if cnt == N:
            result += 1
            cnt -= 1
    else:
        position += 1
        cnt = 0

print(result)
