def solution(topping):
    answer = 0
    a = {}
    b = {}
    for num in topping:
        if num in a:
            a[num] += 1
        else:
            a[num] = 1

    for num in topping:
        a[num] -= 1
        if a[num] == 0:
            del a[num]

        if num in b:
            b[num] += 1
        else:
            b[num] = 1
        if len(a) == len(b):
            answer += 1

    return answer
