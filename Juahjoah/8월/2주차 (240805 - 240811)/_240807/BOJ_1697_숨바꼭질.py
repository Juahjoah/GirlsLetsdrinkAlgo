from collections import deque

def BFS(N, K):
    # answer = 0
    queue = deque()

    visited = [0] * 100001

    # 수빈이의 위치를 추가
    queue.append(N)
    
    while queue:
        current_location = queue.popleft()

        # 동생의 위치가 되었다면, 함수를 종료
        if current_location == K:
            return visited[current_location]

        # 현재 위치를 방문 처리
        # answer += 1

        # 이동할 수 있는 위치 : 할 수 있는 행위는 걷거나, 순간이동하거나
        next_location = [current_location - 1, current_location + 1, current_location * 2]

        for location in next_location:
            # if 0 <= location < 100001 and not visited[location] != True:
            if 0 <= location < 100001 and visited[location] == 0:
                queue.append(location)
                # 이동 경로를 visited에 저장
                visited[location] = visited[current_location] + 1

N, K = map(int, input().split())

print(BFS(N, K))