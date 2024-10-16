def check_number():
    stack = []
    current = 1  # 지금 순서를 저장할 변수
    index = 0    # 대기열을 확인할 인덱스 값

    # 번호 순서대로 통과하는 로직 구현
    while index < N or (stack and stack[-1] == current):
        # 대기열 맨 앞의 학생 번호가 순서와 일치하는 경우
        if index < N and input_list[index] == current:
            current += 1
            index += 1

        # 대기열의 맨 앞의 번호가 일치하지 않으면 스택에 추가하고 다음 숫자로 넘어가기
        elif index < N and input_list[index] != current:
            stack.append(input_list[index])
            index += 1

        # 스택의 맨 위의 값이 현재 간식 번호와 일치하는 경우
        while stack and stack[-1] == current:
            stack.pop()
            current += 1


    if len(stack) == 0 and current == N+1: # 스택이 비어있고, 간식의 순서가 동일하다면,
        print("Nice")
    else:
        print("Sad")


    # for문에 모든 내용을 담으면, 순서를 처리하기 까다로워 진다!
    # for i in range(1, N+1):
    #     if i == input_list[i-1]:
    #         continue
    #     else:
    #         # 번호 순서가 맞지 않는다면, stack에서 값을 꺼내기
    #         stack.append(input_list[i-1])
    #         s_number = stack.pop()
    #         if i == s_number:
    #             continue
    #         else:
    #             # 비교해도 맞지 않다면, stack에 담은 다음에 다시 for문으로 돌아가기
    #             stack.append(input_list[i-1])



N = int(input())
input_list = list(map(int, input().split()))

check_number()


# pass와 continue의 차이
# pass: 실행할 코드가 없거나, 특정 조건에서 아무 작업도 하지 않도록 할 때 사용.
#       그냥 넘어가지만, 반복문을 종료하지 않고 계속 진행함.
# continue: 반복문에서 해당 조건을 만나면 그 이후 코드를 건너뛰고, 다음 반복으로 넘어감.


# stack의 push와 append
# push: 스택에 데이터를 추가할 때 사용하는 용어. 대부분의 프로그래밍 언어에서 사용.
# append: 파이썬에서는 리스트의 맨 끝에 데이터를 추가할 때 사용하며, 스택의 push와 동일한 역할을 함.