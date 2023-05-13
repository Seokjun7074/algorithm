def solution(players, callings):
    hashmap = dict()
    for i in range(len(players)):
        hashmap[players[i]] = i
    for called in callings:
        idx = hashmap[called]
        hashmap[called] -= 1
        hashmap[players[idx - 1]] += 1
        players[idx - 1], players[idx] = players[idx], players[idx - 1]
    return players
