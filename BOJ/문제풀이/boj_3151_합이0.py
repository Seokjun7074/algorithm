import sys

input = sys.stdin.readline
N = int(input())
arr = sorted(map(int, input().split()))

answer = 0

for i in range(N - 2):
    if arr[i] > 0:
        break

    start, end = i + 1, N - 1
    while start < end:
        s = arr[i] + arr[start] + arr[end]
        if s == 0:
            if arr[start] == arr[end]:  # 같은 숫자인 경우
                count = end - start + 1
                answer += count * (count - 1) // 2  # 조합 공식 nC2
                break  # 종료
            else:
                left_count, right_count = 1, 1
                while start + 1 < end and arr[start] == arr[start + 1]:
                    start += 1
                    left_count += 1
                while end - 1 > start and arr[end] == arr[end - 1]:
                    end -= 1
                    right_count += 1
                answer += left_count * right_count
            start += 1
            end -= 1
        elif s < 0:
            start += 1
        else:
            end -= 1

print(answer)
