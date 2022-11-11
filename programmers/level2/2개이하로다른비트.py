def solution(numbers):
    answer = []
    for num in numbers:
        arr = bin(num)[2:]
        if (arr[-1] == '0'):
            answer.append(num+1)
        else:
            arr = '0'+arr
            binNumber = getMinBin(arr)
            answer.append(int(binNumber, 2))
    return answer


def getMinBin(num):
    num = list(num)
    for i in reversed(range(len(num))):
        if (num[i] == '0'):
            num[i] = '1'
            num[i+1] = '0'
            return (''.join(num))


solution([2, 7])
