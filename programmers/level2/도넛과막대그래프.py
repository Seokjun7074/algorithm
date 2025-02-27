# 도넛 = 1출 2입?? 나머지
# 막대 = 0출 1이상입
# 8자 = 2출 2이상 입
# 생성 정점 = 2이상 출/  0입


# 아무 노드나 가서 모양 확인
# 확인된 노드 dfs로 따라가면서 방문처리
def solution(edges):
    answer = [0, 0, 0, 0]  # 생성, 도넛, 막대, 8자
    maxNodeNum = 0
    for s, e in edges:
        m = max(s, e)
        maxNodeNum = max(maxNodeNum, m)
    # [출, 입]
    g = [[0, 0] for _ in range(maxNodeNum + 1)]
    for s, e in edges:
        # g[나가는 간선, 들어오는 간선]
        # s에서 e로
        g[s][0] += 1
        g[e][1] += 1

    for i in range(len(g)):
        outputCnt, inputCnt = g[i]
        # 생성노드
        if outputCnt >= 2 and inputCnt == 0:
            answer[0] = i
        # 막대노드
        if outputCnt == 0 and inputCnt >= 1:
            answer[2] += 1
        if outputCnt == 2 and inputCnt >= 2:
            answer[3] += 1
    # 도넛 노드 계산
    answer[1] = g[answer[0]][0] - sum(answer[1:])

    return answer
