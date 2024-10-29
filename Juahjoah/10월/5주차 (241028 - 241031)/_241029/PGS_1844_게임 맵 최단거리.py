from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]


def BFS(maps):
    M = len(maps[0])
    N = len(maps)
    
    visited = [[0]*M for _ in range(N)]
    
    queue = deque()
    queue.append((0, 0))
    visited[0][0] = 1
    # move = 1
    
    while queue:
        x, y = queue.popleft()
        
        if x == N - 1 and y == M - 1:
            return visited[x][y]
        
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            
            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0 and maps[nx][ny] == 1:
                queue.append((nx, ny))
                visited[nx][ny] = visited[x][y] + 1
                # move += 1
                
    return -1
    

def solution(maps):    
    # answer = BFS(maps)
    return BFS(maps)
