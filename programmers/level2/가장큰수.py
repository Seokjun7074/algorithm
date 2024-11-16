def solution(numbers):
    answer = ""
    a = list(map(str, numbers))
    a.sort(reverse=True, key=lambda x: x * 3)
    for x in a:
        answer += x
    return str(int(answer))
