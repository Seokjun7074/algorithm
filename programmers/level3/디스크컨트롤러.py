import heapq


def solution(jobs):
    jobs.sort(key=lambda x: x[0])  # 요청 시각 기준 정렬
    time = 0  # 현재 시간
    answer = 0  # 총 소요 시간
    cnt = 0  # 완료된 작업 수
    maxCnt = len(jobs)  # 작업 개수
    hq = []  # 대기열 (소요 시간 기준 최소 힙)
    job_idx = 0  # jobs 리스트에서 처리할 인덱스

    while cnt < maxCnt:
        # 현재 시각까지 들어올 수 있는 작업을 대기열에 추가
        while job_idx < maxCnt and jobs[job_idx][0] <= time:
            heapq.heappush(
                hq, (jobs[job_idx][1], jobs[job_idx][0])
            )  # (소요시간, 요청시간)
            job_idx += 1

        if hq:
            # 대기열에서 소요 시간이 가장 짧은 작업 실행
            cur_duration, cur_start = heapq.heappop(hq)
            time += cur_duration
            answer += time - cur_start  # 대기 시간 + 실행 시간
            cnt += 1
        else:
            # 대기열이 비어 있으면 다음 작업 요청 시간으로 점프
            time = jobs[job_idx][0]

    return answer // maxCnt  # 평균 반환
