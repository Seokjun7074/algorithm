def solution(n, words):
    answer = [0, 0]
    dic = {}
    startword = words[0]
    dic[startword] = 0
    for i in range(1, len(words)):
        if startword[-1] == words[i][0]:
            if words[i] not in dic:
                dic[words[i]] = 0
                startword = words[i]
            else:
                answer[0] = (i + 1) % n if (i + 1) % n != 0 else n
                answer[1] = (i + 1) // n + 1 if (i + 1) % n != 0 else (i + 1) // n
                break
        else:
            answer[0] = (i + 1) % n if (i + 1) % n != 0 else n
            answer[1] = (i + 1) // n + 1 if (i + 1) % n != 0 else (i + 1) // n
            break

    return answer
