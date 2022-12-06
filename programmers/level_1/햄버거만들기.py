def solution(ingredient):
    burger = []
    count = 0
    for x in ingredient:
        burger.append(x)
        if burger[-4:] == [1, 2, 3, 1]:
            count += 1
            del burger[-4:]
    return count
