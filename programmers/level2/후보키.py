from itertools import combinations


def solution(relation):
    answer = []
    columnLength = len(relation[0])
    rowLength = len(relation)
    column = [i for i in range(columnLength)]

    keyList = []
    keyDict = dict()
    for i in range(columnLength):
        keyDict[i] = 0

    for i in range(1, columnLength):
        for comb in combinations(column, i):
            keySet = set()
            for row in relation:
                subKey = tuple(row[col] for col in comb)
                keySet.add(subKey)
            if len(keySet) == rowLength:
                keyList.append(comb)
    # 최소성 검사
    for k in keyList:
        isMinimal = True
        for existingKey in answer:
            if set(existingKey).issubset(
                set(k)
            ):  # 기존 후보키가 현재 키의 부분집합이면 제외
                isMinimal = False
                break
        if isMinimal:
            answer.append(k)

    if len(answer) == 0:
        return 1
    return len(answer)
