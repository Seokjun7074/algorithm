N = int(input())
numberList = list(map(int, input().split()))
numberList.sort()

M = int(input())
findList = list(map(int, input().split()))


def binary(target):
    left = 0
    right = N - 1

    while left <= right:
        mid = (left + right) // 2
        if numberList[mid] == target:
            return True

        if target < numberList[mid]:
            right = mid - 1
        elif target > numberList[mid]:
            left = mid + 1


for i in range(M):
    if binary(findList[i]):
        print(1)
    else:
        print(0)
