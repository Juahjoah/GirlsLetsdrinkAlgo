
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def BFS(N, M, input_list):
    answer = 0
    visited = [[0]*M for _ in range(N)]
    queue = []

    for i in range(N):
        for j in range(M):
            if input_list[i][j] == "I":
                queue.append((i,j))
                visited[i][j] = 1

    while queue:
        x, y = queue.pop()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            # 이동 가능한 곳인지 확인
            # if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0 and input_list[nx][ny] == "O" and input_list[nx][ny] != "X":
            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0 and input_list[nx][ny] != "X":
                visited[nx][ny] = 1
                queue.append((nx, ny))
                # 사람을 만났다면, 값을 1 더하기
                if input_list[nx][ny] == "P":
                    answer += 1
    if answer == 0:
        return "TT"
    return answer


N, M = map(int, input().split())
# input_list = [list(input().split()) for _ in range(N)]
input_list = [list(input().strip()) for _ in range(N)]

print(BFS(N, M, input_list))