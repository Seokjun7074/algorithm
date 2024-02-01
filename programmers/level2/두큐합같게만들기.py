from collections import deque


def solution(queue1, queue2):
    q1, q2 = deque(queue1), deque(queue2)
    s1, s2 = sum(q1), sum(q2)
    count, max_count = 0, len(q1) * 4

    if s1 == s2:
        return 0
    elif (s1 + s2) % 2 == 1:
        return -1

    while True:
        if s1 > s2:
            target = q1.popleft()
            q2.append(target)
            s1 -= target
            s2 += target
            count += 1
        elif s2 > s1:
            target = q2.popleft()
            q1.append(target)
            s2 -= target
            s1 += target
            count += 1
        else:
            break
        if count > max_count:
            return -1

    return count
