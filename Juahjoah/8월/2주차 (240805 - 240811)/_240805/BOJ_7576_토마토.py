from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def BFS(M, N ,input_arr):
    answer = -1                        # 이동 횟수
    queue = deque()
    # 시작점 담기 : 1이 시작점
    for i in range(N):
        for j in range(M):
            if input_arr[i][j] == 1:
                queue.append((i, j))

    while queue :
        answer += 1                         # 날짜 추가
        for _ in range(len(queue)):
            x, y = queue.popleft()          # 새로운 위치를 큐에서 하나씩 빼기

            # 네 방향을 순회하면서 익지 않은 토마토(0)를 익은 토마토(1)로 변경
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                # 범위 내에 있고, 익지 않은 토마토(0)이며, 토마토가 들어있는 칸인 경우
                if 0 <= nx < N and 0 <= ny < M and input_arr[nx][ny] == 0 and input_arr[nx][ny] != -1 :
                    input_arr[nx][ny] = 1
                    queue.append((nx, ny))  # 새로운 위치를 추가

    # 모든 토마토가 익지 않았다면 -1을 출력
    for i in range(N):
        for j in range(M):
            if input_arr[i][j] == 0:
                return -1
    return answer


M, N = map(int, input().split())
input_arr = [list(map(int, input().split())) for _ in range(N)]

print(BFS(M, N ,input_arr))