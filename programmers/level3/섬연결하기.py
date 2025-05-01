def solution(n, costs):
    answer = 0
    parents = [i for i in range(n)]

    def find(x):
        if x != parents[x]:
            parents[x] = find(parents[x])
        return parents[x]

    def union(a, b):
        root_a = find(a)
        root_b = find(b)
        if root_a != root_b:
            if root_a > root_b:
                parents[root_a] = root_b
            else:
                parents[root_b] = root_a
            return True
        return False

    costs.sort(key=lambda x: x[2])
    for a, b, c in costs:
        if union(a, b):
            answer += c

    return answer
