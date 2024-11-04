def solution(genres, plays):
    answer = []
    music = dict()
    for i in range(len(plays)):
        if genres[i] not in music:
            music[genres[i]] = []
        music[genres[i]].append([plays[i], i])
    print(music.items())

    # x[1]는 value기준 정렬
    sorted_music = dict(
        sorted(music.items(), key=lambda x: sum(m[0] for m in x[1]), reverse=True)
    )
    for key, value in sorted_music.items():
        sorted_value = sorted(value, key=lambda x: x[0], reverse=True)
        for x in sorted_value[:2]:
            answer.append(x[1])

    return answer
