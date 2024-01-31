def solution(k, tangerine):
    answer = 1
    sum = 0
    dict = {}
    for i in list(set(tangerine)):
        dict[i] = 0
    for i in tangerine:  #
        dict[i] += 1
    dict = sorted(dict.items(), key=lambda x: x[1], reverse=True)
    for x in dict:
        if k <= sum + x[1]:
            break
        if k > sum + x[1]:
            sum += x[1]
            answer += 1
    return answer
