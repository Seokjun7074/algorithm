def solution(n):
    result = []
    while n > 0:
        t = n % 3
        if t == 0:
            t = 4
            n -= 1
        result.append(str(t))
        n = n // 3
        print(n)
    return "".join(result[::-1])
