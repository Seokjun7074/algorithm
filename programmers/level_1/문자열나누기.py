def solution(s):
    answer = 0
    first = ''
    sameCount = 1
    otherCount = 0

    for letter in s:
        if (first == ''):
            first = letter
            continue
        if (first == letter):
            sameCount += 1
        else:
            otherCount += 1
        if (sameCount == otherCount):
            first = ''
            sameCount = 1
            otherCount = 0
            answer += 1
    if (len(first) > 0):
        answer += 1
    return answer


# solution('banana')
# solution("abracadabra")
# solution("aaabbaccccabba")
# solution("a")
