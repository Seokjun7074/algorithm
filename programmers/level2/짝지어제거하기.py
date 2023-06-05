def solution(s):
    answer = -1
    stack = []
    for x in s:
        if len(stack) == 0:
            stack.append(x)
        elif stack[-1] == x:
            stack.pop()
        else:
            stack.append(x)
    if len(stack) == 0:
        return 1
    else:
        return 0
