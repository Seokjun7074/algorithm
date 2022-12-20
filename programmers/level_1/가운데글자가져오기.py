def solution(s):
    half = len(s)//2
    answer = ''
    if(len(s) % 2 == 0):
        answer = s[half-1:half+1]
    else:
        answer = s[int(half)]
    return answer
