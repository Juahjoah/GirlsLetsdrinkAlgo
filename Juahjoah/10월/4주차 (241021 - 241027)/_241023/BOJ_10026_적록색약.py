from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def BFS(i, j, text):
    queue = deque()
    queue.append((i, j))

    while queue:
        x, y = queue.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == 0 and input_list[nx][ny] == text:
                visited[nx][ny] = 1
                queue.append((nx, ny))

def BFS_RG(k, l, text):
    if len(text) > 1:           # R,G가 같이 들어온 경우,
        queue = deque()
        queue.append((k, l))

        while queue:
            x, y = queue.popleft()

            for d in range(4):
                nx, ny = x + dx[d], y + dy[d]

                if 0 <= nx < N and 0 <= ny < N and visited_RG[nx][ny] == 0 and (input_list[nx][ny] == "R" or input_list[nx][ny] == "G"):
                    visited_RG[nx][ny] = 1
                    queue.append((nx, ny))

    else:                       # B인 경우,
        queue = deque()
        queue.append((k, l))

        while queue:
            x, y = queue.popleft()

            for d in range(4):
                nx, ny = x + dx[d], y + dy[d]

                if 0 <= nx < N and 0 <= ny < N and visited_RG[nx][ny] == 0 and input_list[nx][ny] == "B":
                    visited_RG[nx][ny] = 1
                    queue.append((nx, ny))


N = int(input())
input_list = [list(input()) for _ in range(N)]

visited = [[0]*N for _ in range(N)]
visited_RG = [[0]*N for _ in range(N)]

answer = 0
answer_RG = 0
answer_B = 0

# 일반 사용자의 경우
for i in range(N):
    for j in range(N):
        if visited[i][j] == 0 and input_list[i][j] == "R":
            visited[i][j] = 1
            BFS(i, j, "R")
            answer += 1
        elif visited[i][j] == 0 and input_list[i][j] == "G":
            visited[i][j] = 1
            BFS(i, j, "G")
            answer += 1
        elif visited[i][j] == 0 and input_list[i][j] == "B":
            visited[i][j] = 1
            BFS(i, j, "B")
            answer += 1
        else:
            continue

# 적녹색약인 경우
for k in range(N):
    for l in range(N):
        if visited_RG[k][l] == 0 and (input_list[k][l] == "R" or input_list[k][l] == "G"):
            visited_RG[k][l] = 1
            BFS_RG(k, l, ("R", "G"))
            answer_RG += 1
        elif visited_RG[k][l] == 0 and input_list[k][l] == "B":
            visited_RG[k][l] = 1
            BFS_RG(k, l, "B")
            answer_B += 1
        else:
            continue

print(answer, (answer_RG + answer_B))