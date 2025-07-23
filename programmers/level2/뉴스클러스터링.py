import math


def solution(str1, str2):
    NUM = 65536
    str1 = str1.upper()
    str2 = str2.upper()
    set1 = []
    set2 = []

    for i in range(len(str1) - 1):
        s1 = str1[i]
        s2 = str1[i + 1]
        if s1.isalpha() and s2.isalpha():
            set1.append(s1 + s2)
    for i in range(len(str2) - 1):
        s1 = str2[i]
        s2 = str2[i + 1]
        if s1.isalpha() and s2.isalpha():
            set2.append(s1 + s2)

    d1 = {}
    d2 = {}
    for s in set1:
        if s in d1:
            d1[s] += 1
        else:
            d1[s] = 1
    for s in set2:
        if s in d2:
            d2[s] += 1
        else:
            d2[s] = 1

    intersection = 0
    union = 0

    for s in d1:
        if s in d2:
            intersection += min(d1[s], d2[s])
    union = len(set1) + len(set2) - intersection
    if intersection == 0 and union == 0:
        return NUM

    return math.floor(intersection / union * NUM)
