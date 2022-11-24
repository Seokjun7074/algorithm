import sys
sys.stdin = open('input.txt', 'r')

num = int(input())
arr = list(map(int, input().split(' ')))
v = int(input())
count = 0
for x in range(0, num):
    if(arr[x] == v):
        count += 1
print(count)
