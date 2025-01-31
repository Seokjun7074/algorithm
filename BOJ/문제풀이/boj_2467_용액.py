import sys

input = sys.stdin.readline

N = int(input())
liquid = list(map(int, input().split()))
liquid.sort()

result = 1000000000 * 2 + 1  # 두 용액의 합
answer = []

start = 0
end = N - 1

while start < end:
    s = liquid[start] + liquid[end]

    if s == 0:
        answer = [liquid[start], liquid[end]]
        break
    if abs(s) < result:
        result = abs(s)
        answer = [liquid[start], liquid[end]]

    if s > 0:
        end -= 1
    if s < 0:
        start += 1

for x in answer:
    print(x, end=" ")
