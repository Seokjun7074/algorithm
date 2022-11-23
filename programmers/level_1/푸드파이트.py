def solution(food):
    answer = ''
    reverse = ''
    for x in range(1, len(food)):
        if(food[x] % 2 == 1):
            food[x] = food[x]-1
    for x in range(1, len(food)):
        i = int(food[x]/2)
        answer += str(x)*i
    reverse = answer[::-1]
    answer = (answer+'0'+reverse)

    return answer
