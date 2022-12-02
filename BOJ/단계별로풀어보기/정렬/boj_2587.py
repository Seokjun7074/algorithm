import sys
sys.stdin = open('input.txt', 'r')

arr = []
for x in range(5):
    arr.append(int(input()))
arr.sort()
print(sum(arr)//5)
print(arr[2])
