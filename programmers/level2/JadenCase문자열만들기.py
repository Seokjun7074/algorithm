def solution(s):
    answer = []
    arr = s.split(" ")

    for word in arr:
        if len(word) == 0:
            answer.append("")
            continue
        tmp = ""
        for i, w in enumerate(word):
            if i == 0:
                tmp += w.upper()
            else:
                tmp += w.lower()
        answer.append(tmp)
    answer = " ".join(answer)
    return answer
