def solution(phone_book):
    answer = True
    dic = {}
    for p in phone_book:
        dic[p] = 1
    for phone in phone_book:
        for i in range(len(phone)):
            target = phone[: i + 1]
            if target in dic and target != phone:
                answer = False
        if answer == False:
            break
    return answer
