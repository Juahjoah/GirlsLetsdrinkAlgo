from collections import deque

# 네 방향 이동을 위한 리스트 (상, 우, 하, 좌 순서)
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def BFS(N, M, grid):
    # 목표 지점(2)의 위치를 찾기
    target_x, target_y = None, None
    for i in range(N):
        for j in range(M):
            if grid[i][j] == 2:  # 목표 지점을 찾으면 위치를 저장
                target_x, target_y = i, j
                break
        if target_x is not None:  # 목표 지점을 찾으면 더 이상 탐색하지 않음
            break
    
    # BFS를 위한 큐 초기화, 목표 지점에서 출발
    queue = deque([(target_x, target_y)])
    # 각 지점까지의 거리를 저장할 배열 초기화, 처음엔 모두 -1로 설정
    distances = [[-1] * M for _ in range(N)]
    distances[target_x][target_y] = 0  # 목표 지점의 거리는 0
    
    # BFS 실행
    while queue:
        x, y = queue.popleft()  # 큐에서 현재 위치를 꺼냄
        
        # 네 방향(상, 우, 하, 좌)으로 이동
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            
            # 이동할 위치가 범위 내에 있고, 갈 수 있는 땅(1)이며, 아직 방문하지 않았다면
            if 0 <= nx < N and 0 <= ny < M and grid[nx][ny] == 1 and distances[nx][ny] == -1:
                distances[nx][ny] = distances[x][y] + 1  # 현재 위치까지의 거리 + 1
                queue.append((nx, ny))  # 새로운 위치를 큐에 추가
    
    # 결과 출력
    for i in range(N):
        for j in range(M):
            if grid[i][j] == 0:  # 원래 갈 수 없는 땅(0)인 경우 0을 출력
                print(0, end=' ')
            else:
                print(distances[i][j], end=' ')  # 갈 수 있는 땅인 경우 거리 출력
        print()

# 입력 처리
N, M = map(int, input().split())  # 지도의 크기 입력
grid = [list(map(int, input().split())) for _ in range(N)]  # 지도 정보 입력

# BFS를 통해 각 지점의 목표 지점까지의 최단 거리 계산 및 출력
BFS(N, M, grid)
