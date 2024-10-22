from collections import deque

dx = [1, 1, 0, -1, -1, -1, 0, 1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]

def BFS(i, j):
    queue = deque()
    queue.append((i, j))

    while queue:
        x, y = queue.popleft()

        for d in range(8):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < M and 0 <= ny < N and visited[nx][ny] == 0 and input_list[nx][ny] == 1:
                visited[nx][ny] = 1
                queue.append((nx, ny))


M, N = map(int, input().split())
input_list = [list(map(int, input().split())) for _ in range(M)]

visited = [[0]*N for _ in range(M)]
answer = 0

for j in range(N):
    for i in range(M):
        if visited[i][j] == 0 and input_list[i][j] == 1:
            visited[i][j] = 1
            BFS(i, j)
            answer += 1
        else:
            continue

print(answer)
