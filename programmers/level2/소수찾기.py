from itertools import permutations


def isPrime(x):
    if x == 1:
        return False
    for i in range(2, x):
        if x % i == 0:
            return False
    return True


def solution(numbers):
    answer = 0
    numList = []
    for i in range(1, len(numbers) + 1):
        for s in permutations(numbers, i):
            stringNumber = "".join(list(s))
            if int(stringNumber) == 0:
                continue
            numList.append(int(stringNumber))
        numList = list(set(numList))

    for i in numList:
        if isPrime(i):
            answer += 1
    return answer
