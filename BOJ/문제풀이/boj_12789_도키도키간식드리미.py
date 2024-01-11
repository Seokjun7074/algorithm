n = int(input())
student = list(map(int, input().split()))
stack = []
curNumber = 1

while student:
    if student[0] == curNumber:
        student.pop(0)
        curNumber += 1
    else:
        stack.append(student.pop(0))

    while stack:
        if stack[-1] == curNumber:
            stack.pop()
            curNumber += 1
        else:
            break

if not stack:
    print("Nice")
else:
    print("Sad")
