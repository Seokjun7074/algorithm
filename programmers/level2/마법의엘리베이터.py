def solution(storey):
    answer = 0
    arr = list(map(int, list(str(storey))))[::-1] + [0]

    for i in range(len(arr)):
        num = arr[i]
        if num > 5:
            answer += 10 - num
            arr[i + 1] += 1
        elif num < 5:
            answer += num
        else:
            if arr[i + 1] >= 5:
                answer += 10 - num
                arr[i + 1] += 1
            else:
                answer += num

    return answer
