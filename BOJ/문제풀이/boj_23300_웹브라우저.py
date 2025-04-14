import sys

input = sys.stdin.readline
N, Q = map(int, input().split())

cur_page = 0  # 현재 접속중인 페이지
back_stack = []
front_stack = []


def back(front_stack, back_stack, cur_page):
    # 1. 뒤로가기
    # if 뒤로가기 공간 페이지 >= 1
    # 현재 페이지 앞으로가기 공간에 저장
    # 뒤고가기 공간에 가장 최근 페이지 접속(스택에서 pop)
    if len(back_stack) < 1:
        return cur_page
    front_stack.append(cur_page)
    new_page = back_stack.pop()
    return new_page


def front(front_stack, back_stack, cur_page):
    # 2. 앞으로 가기
    # if 앞으로가기 공간 페이지 >= 1
    # 현재 페이지 뒤로가기 공간에 저장
    # 앞으로가기 공간에 가장 최근 페이지 접속(스택에서 pop)
    if len(front_stack) < 1:
        return cur_page
    back_stack.append(cur_page)
    new_page = front_stack.pop()
    return new_page


def access(access_page, back_stack, cur_page):
    # 3. 웹 접속
    # 앞으로가기 스택 전부 삭제
    # if 첫 접속이 아닌 경우
    #   현재 페이지를 뒤로가기 공간에 추가
    #   다음에 접속할 페이지를 현재 페이지로 갱신
    # else
    #   현재 페이지를 뒤로가기 공간에 추가 안함

    new_front_page = []
    if cur_page != 0:  # 첫 접속이 아닌 경우
        back_stack.append(cur_page)

    return access_page, new_front_page


def compress(back_stack):
    # 4. 압축
    # 뒤로가기 공간에서 같은 번호의 페이지가 연속 2번 이상 등장하면
    # 가장 최근꺼만 남김
    new_back_stack = []
    for i in range(len(back_stack)):
        if len(new_back_stack) == 0:
            new_back_stack.append(back_stack[i])
        else:
            if new_back_stack[-1] == back_stack[i]:
                continue
            else:
                new_back_stack.append(back_stack[i])
    return new_back_stack


for _ in range(Q):
    input_msg = list(input().split())
    cmd = input_msg[0]
    if cmd == "A":
        access_page = int(input_msg[1])
        cur_page, front_stack = access(access_page, back_stack, cur_page)
    if cmd == "B":
        cur_page = back(front_stack, back_stack, cur_page)
    if cmd == "F":
        cur_page = front(front_stack, back_stack, cur_page)
    if cmd == "C":
        back_stack = compress(back_stack)


print(cur_page)
if len(back_stack) == 0:
    print(-1)
else:
    print(*back_stack[::-1])

if len(front_stack) == 0:
    print(-1)
else:
    print(*front_stack[::-1])
