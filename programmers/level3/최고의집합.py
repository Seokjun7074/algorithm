def solution(n, s):
    answer = []

    while n > 0:
        cur = s // n
        if cur == 0:
            break
        n -= 1
        s -= cur
        answer.append(cur)
    sorted(answer)
    if len(answer) == 0:
        return [-1]
    return answer
