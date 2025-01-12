def solution(word):
    alpha = ["A", "E", "I", "O", "U"]
    words = []

    def dfs(cur):
        if len(cur) > 5:  # 단어 길이가 5를 초과하면 종료
            return
        if cur:  # 현재 단어가 있다면 리스트에 추가
            words.append(cur)
        for char in alpha:  # 다음 글자 추가
            dfs(cur + char)

    dfs("")  # 초기값으로 빈 문자열부터 시작
    words.sort()  # 사전순 정렬

    return words.index(word) + 1  # word의 인덱스 + 1 반환
