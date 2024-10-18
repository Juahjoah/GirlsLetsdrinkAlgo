
N = int(input())
answer = 0        # 누적 점수를 담을 변수
stack = []

for i in range(N):
    input_list = list(map(int, input().split()))

    if len(input_list) > 1:
        stack.append(input_list)

    if stack: # 스택에 값이 있다면,
        # 맨 앞에 있는 stack의 time 값을 계속 빼준다!
        stack[-1][2] -= 1
        if stack[-1][2] == 0: # 업무가 끝났다면,
            answer += stack.pop()[1] # 점수를 더해서 종료!

print(answer)


# stack에 담은 이후, pop을 해서 값을 조정하려고 했으나, 그렇게 진행하는 경우에 새로 과제가 들어왔을 때 처리하기가 까다로움
# stack에 담을 때, [과제의 점수, 과제의 시간, 과제의 남은 시간]을 담아서, 남은 시간을 계속 빼주는 방식으로 진행하면, 쉽게 해결 가능


""" 함수로 빼기
def homework(N, input_list):
    answer = 0
    stack = []

    for i in range(N):
        current_task = input_list[i]

        if len(current_task) > 1:
            # 새로운 과제 [점수, 남은 시간]을 스택에 추가
            stack.append([current_task[1], current_task[2]])

        if stack:  # 스택에 값이 있다면,
            # 스택의 가장 위에 있는 과제의 남은 시간을 1분 줄이기
            stack[-1][1] -= 1
            if stack[-1][1] == 0:         # 업무가 끝났다면,
                answer += stack.pop()[0]  # 과제 점수를 합산

    print(answer)


N = int(input()) 
input_list = [list(map(int, input().split())) for _ in range(N)]  # 각 분에 주어진 과제 정보 미리 입력 받기

homework(N, input_list)

"""