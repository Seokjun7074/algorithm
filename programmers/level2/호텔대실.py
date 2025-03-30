from collections import deque


def solution(book_time):
    answer = []
    book_time = [
        (int(s[:2]) * 60 + int(s[3:]), int(e[:2]) * 60 + int(e[3:]))
        for s, e in book_time
    ]
    book_time.sort()
    q = deque(book_time)
    while q:
        cur = q.popleft()
        start, end = cur[0], cur[1]
        if len(answer) < 1:
            answer.append([(start, end)])
            continue
        flag = False
        for i in range(len(answer)):
            finishedTime = answer[i][-1][-1] + 10
            if finishedTime <= start:
                answer[i].append((start, end))
                flag = True
                break
        if not flag:
            answer.append([(start, end)])
    return len(answer)
