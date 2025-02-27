def makeNum(num, target):
    answer = []
    while num > 0:
        n = num % target
        num = num // target
        answer.append(n)
    answer.reverse()
    s = "".join(map(str, answer))
    return s


def isPrime(num):
    if num == 1:
        return False
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True


def solution(n, k):
    answer = 0
    result = makeNum(n, k).split("0")
    for num in result:
        if len(num) == 0:
            continue
        if isPrime(int(num)):
            answer += 1
    return answer
