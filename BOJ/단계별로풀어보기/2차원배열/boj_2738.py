import sys
sys.stdin = open('input.txt', 'r')

[N, M] = list(map(int, input().split(' ')))
A = []
B = []
for x in range(N):
    A.append(list(map(int, input().split(' '))))
for x in range(N):
    B.append(list(map(int, input().split(' '))))

for row in range(N):
    for col in range(M):
        print(A[row][col] + B[row][col], end=' ')
    print()
