import sys
sys.stdin = open('input.txt', 'r')

[N, k] = list(map(int, input().split(' ')))
score = list(map(int, input().split(' ')))
score.sort(reverse=True)
print(score[k-1])
