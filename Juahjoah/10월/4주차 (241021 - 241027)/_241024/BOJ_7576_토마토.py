from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


def BFS():
    queue = deque()

    answer = -1

    for i in range(N):
        for j in range(M):
            if visited[i][j] == 0 and input_list[i][j] == 1:
                queue.append((i, j))

    while queue:
        answer += 1

        for _ in range(len(queue)):
            x, y = queue.popleft()

            for d in range(4):
                nx, ny = x + dx[d], y + dy[d]

                if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0 and input_list[nx][ny] == 0:
                    visited[nx][ny] = 1
                    input_list[nx][ny] += 1
                    queue.append((nx, ny))

    for i in range(N):
        for j in range(M):
            if input_list[i][j] == 0:
                answer = -1

    print(answer)


M, N = map(int, input().split())
input_list = [list(map(int, input().split())) for _ in range(N)]

visited = list([0]*M for _ in range(N))

BFS()