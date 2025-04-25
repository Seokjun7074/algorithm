import math


def changeTimeToMinute(time):
    t, m = map(int, time.split(":"))
    return t * 60 + m


def calFees(default_minute, default_fee, sub_minute, sub_fee, time):
    if time <= default_minute:
        return default_fee
    else:
        return default_fee + math.ceil((time - default_minute) / sub_minute) * sub_fee


def solution(fees, records):
    answer = []
    car_fee = {}
    car_nums = []
    default_minute, default_fee, sub_minute, sub_fee = fees
    parking = {}

    for s in records:
        time, car_num, cmd = map(str, s.split())
        time = changeTimeToMinute(time)
        if car_num in parking:
            parking[car_num].append(time)
        else:
            parking[car_num] = [time]
    for car_num in parking:
        if len(parking[car_num]) % 2 == 1:
            parking[car_num].append(23 * 60 + 59)
        total_minute = 0
        for i in range(len(parking[car_num])):
            if i % 2 == 0:
                total_minute += parking[car_num][i + 1] - parking[car_num][i]
        fee = calFees(default_minute, default_fee, sub_minute, sub_fee, total_minute)
        car_nums.append(car_num)
        car_fee[car_num] = fee
    car_nums.sort()
    for cn in car_nums:
        answer.append(car_fee[cn])
    return answer


# 분으로 변환
# 입차 후 출차내역 없으면 23:59에 출차로 간주
# 요금 계산법
# 1. 180분 이하
#   기본요금
# 2. 180분 초과
#   기본요금 + |(전체 분 - 기본 시간) / 단위 시간| * 단위 요금
