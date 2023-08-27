import sys

input = sys.stdin.readline


T = int(input())


for _ in range(T):
    cloth = {}
    result = 1
    n = int(input())
    for _ in range(n):
        name, category = input().rstrip().split()

        if not category in cloth:
            cloth[category] = 1
        else:
            cloth[category] += 1

    for i in cloth:
        result *= cloth[i] + 1

    print(result - 1)
