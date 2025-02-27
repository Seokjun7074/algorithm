# 일단 양 가장 많은 곳으로 감


def solution(info, edges):
    answer = []
    v = [False] * len(info)
    v[0] = True

    def dfs(sheep, wolf):
        if sheep > wolf:
            answer.append(sheep)
        else:
            return
        # 다음 노드로 가기
        for s, e in edges:
            if v[s] and not v[e]:
                v[e] = True
                if info[e] == 1:
                    dfs(sheep, wolf + 1)
                if info[e] == 0:
                    dfs(sheep + 1, wolf)
                v[e] = False

    dfs(1, 0)
    print(answer)
    return max(answer)
