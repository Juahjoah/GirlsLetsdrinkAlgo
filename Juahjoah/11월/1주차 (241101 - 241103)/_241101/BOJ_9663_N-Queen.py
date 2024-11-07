dx = [1, 1, 0, -1, -1, -1, 0, 1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]


def DFS(depth):
    global cnt

    if depth == N:
        cnt += 1
        return

    # 탐색
    for i in range(N):
        if board[depth][i] == 0:
            board[depth][i] = 2
            change_list = []

            for d in range(8):
                move_x, move_y = depth + dx[d], i + dy[d]

                while 0 <= move_x < N and 0 <= move_y < N:
                    if board[move_x][move_y] == 0:
                        board[move_x][move_y] = 1
                        change_list.append((move_x, move_y))
                    move_x += dx[d]
                    move_y += dy[d]
            DFS(depth + 1)

            for move_x, move_y in change_list:
                board[move_x][move_y] = 0
            board[depth][i] = 0

N = int(input())
board = [[0]*N for _ in range(N)]


cnt = 0
DFS(0)

print(cnt)