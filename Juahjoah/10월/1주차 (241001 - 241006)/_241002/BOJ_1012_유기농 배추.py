
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def BFS(i, j):
    # 1. queue를 만들기
    queue = [(i, j)]
    visited[i][j] = 1

    # 2. queue에 담겨있는 내용을 확인
    while queue:
        x, y = queue.pop()

        # 3. 4사분면을 돌면서 확인하기
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            # 4. 이동 가능한 곳인지 확인
            for i in range(M):
                for j in range(N):
                    if 0 <= nx < N and 0 <= ny < M and board[nx][ny] == 1 and visited[nx][ny] == 0:
                        # 5. 이동 가능하다면, queue에 넣기
                        visited[nx][ny] = 1
                        queue.append((nx, ny))


T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split())
    board = [[0]*M for _ in range(N)]       # 배추밭 만들기
    visited = [[0]*M for _ in range(N)]     # 방문 배열 만들기


    for _ in range(K):
        X, Y = map(int, input().split())
        board[Y][X] = 1

    cnt_worm = 0                           
    for i in range(N):
        for j in range(M):
            if board[i][j] == 1 and visited[i][j] == 0: # 배추가 심어져 있고, 방문하지 않았다면
                cnt_worm += 1
                BFS(i, j)

    print(cnt_worm)
