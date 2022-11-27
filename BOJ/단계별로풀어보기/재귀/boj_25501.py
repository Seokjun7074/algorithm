import sys
sys.stdin = open('input.txt', 'r')

N = int(input())


def recursion(s, l, r, count):
    if l >= r:
        return [1, count]
    elif s[l] != s[r]:
        return [0, count]
    else:
        count += 1
        return recursion(s, l+1, r-1, count)


def isPalindrome(s):
    count = 1
    return recursion(s, 0, len(s)-1, count)


for x in range(0, N):
    word = str(input())
    answer = isPalindrome(word)
    print(answer[0], answer[1])
