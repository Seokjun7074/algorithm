global zeroCnt
zeroCnt = 0


def deleteZero(string):
    global zeroCnt
    newStr = ""
    for x in string:
        if x == "0":
            newStr += ""
            zeroCnt += 1
        else:
            newStr += x
    return newStr


def solution(s):
    answer = []
    cnt = 0
    while True:
        if s == "1":
            break
        deleted_s = deleteZero(s)
        cnt += 1
        s = str(bin(len(deleted_s))[2:])

    return [cnt, zeroCnt]
