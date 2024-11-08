from collections import deque
    
def solution(rectangle, characterX, characterY, itemX, itemY):
    
    board = [[0]*101 for _ in range(101)]
    
    # board에 주어진 값 기록하기
    for x1, y1, x2, y2 in rectangle:
        x1, y1, x2, y2 = x1 * 2, y1 * 2, x2 * 2, y2 * 2
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                # if i == x1 or i == x2 or j == y1 or j == y2:
                board[i][j] = 1
                    
    # 내부 빈칸을 0으로 채워주기
    for x1, y1, x2, y2 in rectangle:
        x1, y1, x2, y2 = x1 * 2, y1 * 2, x2 * 2, y2 * 2
        for l in range(x1 + 1, x2):
            for m in range(y1 + 1, y2):
                board[l][m] = 0
                    
                    
    def BFS(start_x, start_y):        
        dx = [1, 0, -1, 0]
        dy = [0, -1, 0, 1]
    
        visited = [[0]*101 for _ in range(101)]

        queue = deque()
        queue.append((start_x, start_y, 0)) # 시작점 넣기, 이동 횟수
        visited[start_x][start_y] = 1

        while queue:
            x, y, cnt = queue.popleft()
            
            # 도착하면 값 반환
            if x == itemX * 2 and y == itemY * 2:
                return cnt // 2

            for d in range(4):
                nx, ny = x + dx[d], y + dy[d]
                if 0 < nx <= 100 and 0 < ny <= 100 and board[nx][ny] == 1 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append((nx, ny, cnt+1))
                    
        return -1
    
    # BFS 호출
    return BFS(characterX * 2, characterY * 2)
