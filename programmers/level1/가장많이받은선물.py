def solution(friends, gifts):
    answer = [0] * len(friends)
    dict = {}
    g = [[0] * len(friends) for _ in range(len(friends))]
    level = [0] * len(friends)

    for i in range(len(friends)):
        dict[friends[i]] = i

    for j in gifts:
        [give, get] = j.split(" ")
        g[dict[give]][dict[get]] += 1
        level[dict[give]] += 1
        level[dict[get]] -= 1

    for i in range(len(friends)):
        for j in range(len(friends)):
            if i != j:
                if g[i][j] > g[j][i]:
                    answer[i] += 1
                elif g[i][j] == g[j][i] and level[i] > level[j]:
                    answer[i] += 1

    print(answer)
    return max(answer)
