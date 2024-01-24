import sys

input = sys.stdin.readline

P = int(input())
for _ in range(P):
    cnt = 0
    arr = list(map(int, input().split()))
    test_case = arr[0]
    student = arr[1:]
    for i in range(len(student) - 1, -1, -1):
        for j in range(i):
            if student[j] > student[j + 1]:
                student[j], student[j + 1] = student[j + 1], student[j]
                cnt += 1
    print(test_case, cnt)
