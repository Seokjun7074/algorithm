def solution(s, skip, index):
    answer = ''
    # 97~122
    for x in range(len(s)):
        ascii = ord(s[x])  # 아스키숫자로
        next = ''
        count = 0
        while(count < index):
            ascii += 1
            if(ascii > 122):
                ascii -= 26
            if(chr(ascii) in skip):
                continue
            next = (chr(ascii))
            count += 1
        answer += next
    return answer
