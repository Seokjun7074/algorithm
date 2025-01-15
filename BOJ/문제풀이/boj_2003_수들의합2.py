import sys

input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().split()))

# M보다 작으면 end 증가
# 크거나 같으면 start 증가
# start, end가 만나면 둘다 증가
answer = 0
start = 0
end = 0
cnt = numbers[0]

while end < N and start < N:
    if cnt < M and end + 1 < N:
        end += 1
        cnt += numbers[end]
    else:
        if cnt == M:
            answer += 1
        cnt -= numbers[start]
        start += 1
print(answer)
