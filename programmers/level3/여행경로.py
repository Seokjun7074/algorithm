def solution(tickets):
    answer = []
    tickets.sort()

    def dfs(cur, path):
        if len(path) == len(tickets) + 1:
            answer.append(path[:])
            return

        for i in range(len(tickets)):
            if not v[i] and tickets[i][0] == cur:
                v[i] = True
                new_path = path[:]
                new_path.append(tickets[i][1])
                dfs(tickets[i][1], new_path)
                v[i] = False

    v = [False] * (len(tickets))
    dfs("ICN", ["ICN"])

    return answer[0]
