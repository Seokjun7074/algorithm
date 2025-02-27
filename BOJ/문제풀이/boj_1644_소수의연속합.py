import sys

input = sys.stdin.readline


def getPrimes(n):
    # 에라토스테네스의 체로 소수 리스트를 반환
    prime = [True] * (n + 1)
    prime[0] = prime[1] = False  # 0과 1은 소수가 아님

    for i in range(2, int(n**0.5) + 1):
        if prime[i]:  # i가 소수라면
            for j in range(i * i, n + 1, i):  # i의 배수를 제거
                prime[j] = False

    return [i for i in range(n + 1) if prime[i]]


N = int(input().strip())

arr = getPrimes(N)
answer = 0


if not arr:
    print(0)
    sys.exit()

left = 0
right = 0
num = arr[0]
print(arr)
while right < len(arr):
    if num == N:
        answer += 1
        num -= arr[left]
        left += 1
    elif num < N:
        right += 1
        if right < len(arr):
            num += arr[right]
    else:
        num -= arr[left]
        left += 1

print(answer)
