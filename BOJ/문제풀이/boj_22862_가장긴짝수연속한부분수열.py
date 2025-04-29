N, K = map(int, input().split())
arr = list(map(int, input().split()))

left = 0
right = 0

pop_cnt = 0

answer = 0

while right < N:
    if arr[right] % 2 != 0:
        if pop_cnt < K:
            pop_cnt += 1
            right += 1
        else:
            for i in range(left, N):
                if arr[i] % 2 != 0:
                    left = i + 1
                    pop_cnt -= 1
                    break
    else:
        right += 1
    answer = max(answer, right - left - pop_cnt)
print(answer)
