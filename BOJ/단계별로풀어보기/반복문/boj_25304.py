import sys
sys.stdin = open('input.txt', 'r')

total = int(input())
num = int(input())
sum = 0

for i in range(num):
    price, a = map(int, input().split())
    sum = sum + price * a


if sum == total:
    print("Yes")
else:
    print("No")
