import sys
sys.stdin = open('input.txt', 'r')

arr = list(map(int, str(input())))
arr.sort(reverse=True)
for x in arr:
    print(x, end='')
