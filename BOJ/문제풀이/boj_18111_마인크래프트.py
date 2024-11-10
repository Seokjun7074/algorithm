import sys

input = sys.stdin.readline

N, M, B = map(int, input().split())
block = []
for _ in range(N):
    block.append(list(map(int, input().split())))

cnt = sys.maxsize
resultHeight = 0

for i in range(257):  # 땅 높이
    use_block = 0
    take_block = 0
    for x in range(N):
        for y in range(M):
            if block[x][y] > i:  # 기준 높이보다 높은 땅
                take_block += block[x][y] - i
            else:  # 기준 높이보다 낮은 땅
                use_block += i - block[x][y]

    if use_block > take_block + B:
        continue

    count = take_block * 2 + use_block

    if count <= cnt:
        cnt = count
        resultHeight = i

print(cnt, resultHeight)
