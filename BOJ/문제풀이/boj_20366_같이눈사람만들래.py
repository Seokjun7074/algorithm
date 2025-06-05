import sys

input = sys.stdin.readline

N = int(input())
H = list(map(int, input().split()))

H.sort()  # 투포인터를 쓰기 위해 먼저 정렬
min_diff = abs((H[3] + H[0]) - (H[1] + H[2]))
for i in range(N - 3):
    for j in range(i + 3, N):
        anna = H[i] + H[j]

        l = i + 1
        r = j - 1
        while l < r:
            elsa = H[l] + H[r]
            diff = abs(anna - elsa)
            min_diff = min(diff, min_diff)

            if anna < elsa:
                r -= 1
            else:
                l += 1
print(min_diff)
