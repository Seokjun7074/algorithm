def solution(cap, n, deliveries, pickups):
    answer = 0
    deliveries = deliveries[::-1]
    pickups = pickups[::-1]

    delivery = 0
    pickup = 0
    for i in range(len(pickups)):
        delivery += deliveries[i]
        pickup += pickups[i]

        while pickup > 0 or delivery > 0:
            delivery -= cap
            pickup -= cap
            answer += (n - i) * 2

    return answer
