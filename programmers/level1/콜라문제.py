def solution(a, b, n):
    answer = 0
    while (n >= a):
        extra = n % a
        n = (n//a) * b
        answer += n
        n += extra
    return answer
