def solution(arr1, arr2):
    height, n, width = len(arr1), len(arr1[0]), len(arr2[0])
    answer = [[0 for _ in range(width)] for _ in range(height)]

    for i in range(height):
        for j in range(width):
            for k in range(n):
                answer[i][j] += arr1[i][k] * arr2[k][j]

    return answer
