import sys

sys.setrecursionlimit(10**9)
input = sys.stdin.readline

inputArray = []

while True:
    try:
        inputArray.append(int(input()))
    except:
        break


def solution(arr):
    if len(arr) == 0:
        return
    left = []
    right = []
    root = arr[0]
    for i in range(1, len(arr)):
        if arr[i] < root:
            left.append(arr[i])
        else:
            right.append(arr[i])
    solution(left)
    solution(right)
    print(root)


solution(inputArray)
