import sys
sys.stdin = open('input.txt', 'r')

word = []
N = int(input())
for i in range(N):
    word.append(str(input()))
word = list(set(word))

word.sort()
word.sort(key=len)

for i in word:
    print(i)
