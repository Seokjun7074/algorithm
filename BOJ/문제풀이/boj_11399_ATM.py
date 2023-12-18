import sys

input = sys.stdin.readline

N = int(input())
people = list(map(int, input().split()))
people.sort()

ans = 0

for x in range(1, N + 1):
    ans += sum(people[0:x])
print(ans)
