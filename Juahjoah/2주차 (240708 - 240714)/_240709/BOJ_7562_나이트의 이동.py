
def BFS(board_len, start, goal):
    # 나이트가 이동할 수 있는 8가지 방향
    moves = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

    # 방문 여부를 저장하는 배열 (0으로 초기화)
    visited = [[0] * board_len for _ in range(board_len)]

    # BFS를 위한 리스트 초기화
    queue = [(start[0], start[1], 0)]   # (x, y, 이동 횟수)
    visited[start[0]][start[1]] = 1     # 방문 처리

    while queue:
        x, y, count = queue.pop(0)

        # 목표 위치에 도달하면 이동 횟수를 반환
        if (x, y) == goal:
            return count

        # 나이트가 이동할 수 있는 모든 방향에 대해 탐색
        for dx, dy in moves:
            nx, ny = x + dx, y + dy
            if 0 <= nx < board_len and 0 <= ny < board_len and not visited[nx][ny]:
                visited[nx][ny] = 1     # 방문 처리
                queue.append((nx, ny, count + 1))

    return -1                           # 목표 위치에 도달할 수 없는 경우 (이론상 있을 수 없음)


# input 값 받아오기
N = int(input())
results = []

for _ in range(N):
    board_len = int(input())
    start = tuple(map(int, input().split()))
    goal = tuple(map(int, input().split()))
    result = BFS(board_len, start, goal)
    results.append(result)


for result in results:
    print(result)
