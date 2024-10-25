from collections import deque


# b를 리턴하면 변환 성공
def findWord(a, b):
    diff = 0
    for i in range(len(a)):
        if a[i] != b[i]:
            diff += 1
            if diff >= 2:
                return a
    if diff == 1:
        return b
    else:
        return a


def solution(begin, target, words):
    if target not in words:
        return 0
    answer = len(words)
    v = [False] * len(words)
    q = deque()

    for i, w in enumerate(words):
        if w == begin:
            v[i] = True

    q.append([begin, v, 1])

    while q:
        curWord, curV, curCnt = q.popleft()
        if curWord == target:
            print(curCnt)
            answer = min(answer, curCnt - 1)
        for i, w in enumerate(words):
            result = findWord(curWord, w)
            if not curV[i] and result == w:
                curV[i] = True
                q.append([result, curV, curCnt + 1])
    return answer
