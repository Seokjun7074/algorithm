import sys

input = sys.stdin.readline

word1, word2 = input().strip(), input().strip()
h, w = len(word1), len(word2)
v = [[0] * (w + 1) for _ in range(h + 1)]

for i in range(1, h + 1):
    for j in range(1, w + 1):
        if word1[i - 1] == word2[j - 1]:
            v[i][j] = v[i - 1][j - 1] + 1
        else:
            v[i][j] = max(v[i][j - 1], v[i - 1][j])
print(v[-1][-1])
