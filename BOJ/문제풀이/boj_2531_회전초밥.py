from collections import defaultdict

N, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(N)]
arr = arr + arr[:k]

answer = 0
left, right = 0, 0
check = defaultdict(int)

while right < k:
    check[arr[right]] += 1
    right += 1

for _ in range(N):
    answer = max(answer, len(check) + (1 if c not in check else 0))

    check[arr[right]] += 1
    check[arr[left]] -= 1

    if check[arr[left]] == 0:
        del check[arr[left]]

    right += 1
    left += 1

print(answer)
