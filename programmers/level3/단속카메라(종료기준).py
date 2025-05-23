def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[1])
    print(routes)
    camera = -30001
    for route in routes:
        start, end = route
        if camera < start:
            answer += 1
            camera = end
    return answer
