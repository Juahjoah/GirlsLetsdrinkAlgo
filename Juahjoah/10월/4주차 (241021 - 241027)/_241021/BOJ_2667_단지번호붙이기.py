from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

answer = 0
answer_list = []

def BFS(i, j):
    queue = deque()
    queue.append((i, j))

    answer_cnt = 1                    # 자기 자신도 포함해야 하니까, 1로 시작

    while queue:
        x, y = queue.popleft()

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]

            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == 0 and input_list[nx][ny] == 1:
                visited[nx][ny] = 1
                answer_cnt += 1
                queue.append((nx, ny))

    answer_list.append(answer_cnt)


N = int(input())
input_list = [list(map(int, input())) for _ in range(N)]

visited = list([0]*N for _ in range(N))

for i in range(N):
    for j in range(N):
        if visited[i][j] == 0 and input_list[i][j] == 1:     # 방문하지 않은 곳이고, 집이 있는 곳이라면 BFS 실행 (BFS를 시작하기 전에 1인지 확인)
            visited[i][j] = 1
            BFS(i, j)
            # answer += 1
        else:
            continue

print(len(answer_list))
# answer_list 정렬
answer_list.sort()
for i in answer_list:
    print(i)
