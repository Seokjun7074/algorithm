import sys

input = sys.stdin.readline
n, d, k, c = map(int, input().split())
arr = [int(input()) for _ in range(n)]
arr += arr[: k - 1]
left, right = 0, k
dic = dict()

for i in range(k):
    if arr[i] in dic:
        dic[arr[i]] += 1
    else:
        dic[arr[i]] = 1
if c not in dic:
    sushi = len(dic) + 1
else:
    sushi = len(dic)
# print(arr)
while right < len(arr):
    if dic[arr[left]] == 1:
        del dic[arr[left]]
    else:
        dic[arr[left]] -= 1

    if arr[right] in dic:
        dic[arr[right]] += 1
    else:
        dic[arr[right]] = 1

    # print(arr[left : right + 1], dic)
    if c not in dic:
        sushi = max(sushi, len(dic) + 1)
    else:
        sushi = max(sushi, len(dic))
    left += 1
    right += 1
print(sushi)
