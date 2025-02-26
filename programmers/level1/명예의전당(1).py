def solution(k, score):
    answer = []
    honor = []
    for x in score:
        honor.append(x)
        honor.sort(reverse=True)
        honor = honor[0:k]
        answer.append(honor[-1])
    return answer


# solution(3, [10, 100, 20, 150, 1, 100, 200])
# solution(4, [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000])
