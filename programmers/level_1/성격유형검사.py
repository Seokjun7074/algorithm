def solution(survey, choices):
    answer = ''
    check = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0}

    for i in range(len(choices)):
        if choices[i] < 4:
            check[survey[i][0]] += (choices[i] * 3) % 4
        if choices[i] > 4:
            check[survey[i][1]] += choices[i] % 4
    keys = list(check.keys())

    for i in range(0, len(keys), 2):
        if check[keys[i]] > check[keys[i+1]]:
            answer += keys[i]
        elif check[keys[i]] < check[keys[i+1]]:
            answer += keys[i+1]
        else:
            answer += min(keys[i], keys[i+1])
    return answer


solution(["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5])
