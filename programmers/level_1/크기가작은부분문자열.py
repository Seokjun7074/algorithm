def solution(t, p):
    answer = 0
    for i in range(len(t)-len(p)+1):
        num = t[i:i+len(p)]
        if(int(num) <= int(p)):
            answer += 1
    return answer
