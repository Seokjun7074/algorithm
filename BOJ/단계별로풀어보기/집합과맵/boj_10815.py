import sys
sys.stdin = open('input.txt', 'r')

N = int(input())
arr = set(map(int, input().split()))
M = int(input())
for i in map(int, input().split()):
    if i in arr:
        print(1, end=" ")
    else:
        print(0, end=" ")
