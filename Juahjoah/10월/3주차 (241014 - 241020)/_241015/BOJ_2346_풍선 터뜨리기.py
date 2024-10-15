
from collections import deque

def Balloon():

    for n in range(N):
        # start = input_copy_list.popleft()
        start, next_start = input_copy_list.popleft()

        # answer_list에 자리 값을 담기, 다음 값을 저장함.
        # answer_list.append(start[0])
        answer_list.append(start)
        # next_start = start[1]

        if next_start > 0:
            next_start = -(next_start)+1
        else:
            next_start = -(next_start)

        # next_start로 이동
        input_copy_list.rotate(next_start)


N = int(input())
input_list = list(map(int, input().split()))

# 튜플로 인덱스 값을 각 input 값에 함께 지정해주기
input_copy_list = deque()
for i in range(1, N+1):
    input_copy_list.append((i, input_list[i-1]))

answer_list = []
Balloon()

#for i in answer_list:
#    print(i, end=" ")

print(*answer_list)


# rotate(): 양수면 오른쪽으로, 음수면 왼쪽으로 회전
  # rotate(1)은 오른쪽으로 한 칸씩 이동
  # rotate(-1)은 왼쪽으로 한 칸씩 이동