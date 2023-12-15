import sys

input = sys.stdin.readline


def checkStr(str):
    if str == str[::-1]:
        return "yes"
    return "no"


while True:
    str = input().rstrip()
    if str == "0":
        break
    print(checkStr(str))
