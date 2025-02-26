def solution(n, arr1, arr2):
    answer = []
    binArr1 = []
    binArr2 = []
    for i in range(n):
        binArr1.append(bin(arr1[i])[2:])
        binArr2.append(bin(arr2[i])[2:])
        binArr1[i] = ('0' * (n-len(binArr1[i]))) + binArr1[i]
        binArr2[i] = ('0' * (n-len(binArr2[i]))) + binArr2[i]

        tmp = ''
        for p in range(n):
            if binArr1[i][p] == '1' or binArr2[i][p] == '1':
                tmp += '#'
            elif binArr1[i][p] == '0' and binArr2[i][p] == '0':
                tmp += ' '
        answer.append(tmp)

    return answer
