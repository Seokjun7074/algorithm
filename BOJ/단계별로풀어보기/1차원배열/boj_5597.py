import sys
sys.stdin = open('input.txt', 'r')

student = [False for i in range(30)]

for i in range(28):
    n = int(input())
    student[n-1] = True

for i in range(30):
    if not student[i]:
        print(i+1)
