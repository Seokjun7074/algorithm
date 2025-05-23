def solution(routes):
    answer = 1
    routes.sort(key=lambda x: x[0])
    s, e = routes[0]
    for route in routes[1:]:
        if s <= route[0] <= e:
            s = route[0]
            e = min(route[1], e)
        else:
            answer += 1
            s, e = route
    return answer
