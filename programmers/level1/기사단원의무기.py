def getDivide(num):
    count = 0
    for x in range(1, int(num**(1/2))+1):
        if(num % x == 0):
            if(x == num//x):
                count += 1
            else:
                count += 2
    return count


def solution(number, limit, power):
    answer = 0
    arr = [1]
    for x in range(2, number+1):
        arr.append(getDivide(x))
    for x in range(len(arr)):
        if(arr[x] > limit):
            answer += power
        else:
            answer += arr[x]
    return answer
