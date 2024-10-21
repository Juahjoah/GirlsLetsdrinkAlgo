from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

answer = 0

def BFS(i, j):
    queue = deque()
    queue.append((i, j))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0 and abs(input_list[x][y] - input_list[nx][ny]) <= K:
                visited[nx][ny] = 1
                queue.append((nx, ny))

            # K보다 크기가 커 제대로 동작하지 않은 경우,= BFS 함수 내부가 아니라 바깥에서 처리


N, M, K = map(int, input().split())
input_list = [list(map(int, input().split())) for _ in range(N)]

visited = list([0]*M for _ in range(N))


# 바깥에서 K보다 큰 경우 처리
for i in range(N):
    for j in range(M):
        if visited[i][j] == 0:
            visited[i][j] = 1
            BFS(i, j)
            answer += 1
        else:
            # 이미 방문한 곳은 넘어가기
            continue

print(answer)