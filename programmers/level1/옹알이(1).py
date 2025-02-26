def solution(babbling):
    answer = 0
    speaking = ["aya", "ye", "woo", "ma"]
    for word in babbling:
        for speak in speaking:
            if(speak in word):
                word = word.replace(speak, ' ')
        if(word.strip() == ''):
            answer += 1
    return answer


solution(["aya", "yee", "u", "maa", "wyeoo"])
