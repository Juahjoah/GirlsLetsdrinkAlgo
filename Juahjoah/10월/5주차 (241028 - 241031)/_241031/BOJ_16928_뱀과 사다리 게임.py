from collections import deque


def BFS():
    queue = deque()
    queue.append((1, 0))

    visited = [0]*101

    answer = 99999

    while queue:
        loc, move = queue.popleft()

        if loc == 100:
            if move < answer:
                answer = move
            # return move
            continue

        for i in range(1, 7):
            next_loc = loc + i

            if next_loc <= 100 and visited[next_loc] == 0:
                # for j in range(len(input_list)):

                # 자리에 뱀이나 사다리가 있는 경우,
                if board[next_loc] > 0:
                    # 주사위로 1 이동, 뱀 or 사다리를 타고 이동 = 이동 횟수를 1번으로 처리한다!
                    queue.append((board[next_loc], move + 1))
                    visited[next_loc] = 1
                    visited[board[next_loc]] = 1

                # 뱀이나 사다리가 없는 경우,
                else:
                    queue.append((next_loc, move + 1))    # 위치를 담아서 이동하기
                    visited[next_loc] = 1

    return answer

N, M = map(int, input().split())
input_list = [list(map(int, input().split())) for _ in range(N+M)]

board = [0] * 101

for l in range(len(input_list)):
    board[input_list[l][0]] = input_list[l][1]

print(BFS())
