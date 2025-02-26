def solution(babbling):
    arr = ["aya", "ye", "woo", "ma"]
    answer = 0
    for word in babbling:
        for w in arr:
            if w * 2 not in word:
                word = word.replace(w, ' ')
        if len(word.strip()) == 0:
            answer += 1
    print(answer)
    return answer


solution(["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"])
