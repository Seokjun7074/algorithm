import sys
sys.stdin = open('input.txt', 'r')

arr = [[0]*100 for _ in range(100)]

for x in range(int(input())):
    m, n = map(int, input().split())
    for i in range(m, m+10):
        for j in range(n, n+10):
            arr[i][j] = 1

paper = 0
for x in arr:
    paper += x.count(1)

print(paper)
