# 변수명을 신경쓰자! 보편적인 python 형식을 따라 가자!

from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


# 미로를 탐색할 BFS 함수 구현
def BFS(N, M):
    queue = deque([(0,0)])
    visited[0][0] = True

    while queue:
        x, y = queue.popleft()
        # 종료 조건 추가 : (N, M)에 도착하면 종료
        if x ==  N - 1 and y == M - 1:
            return input_arr[x][y]

        # 상하좌우 이동 탐색
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            # 범위 내에 포함되어야 하고, 방문하지 않았어야 하며, 미로로 갈 수 있는 길이 존재해야 함.
            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == False and input_arr[nx][ny] == 1:
                queue.append((nx, ny))
                visited[nx][ny] = True
                # 이동 가능한 칸이라면, 현재 칸의 값에 1을 더하여 거리 갱신
                input_arr[nx][ny] = input_arr[x][y] + 1

    # 배열을 다 돌았음에도 도착할 수 없는 경우,
    return -1


N, M = map(int, input().split())
input_arr = [list(map(int, input())) for _ in range(N)]
visited = [[False] * (M) for _ in range(N)]

print(BFS(N, M))