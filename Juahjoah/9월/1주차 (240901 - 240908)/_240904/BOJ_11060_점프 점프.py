from collections import deque

def BFS(N, input_list):
    # queue = [input_list[0]] # 초기 값을 첫번째 위치로 설정
    queue = deque([(0, 0)])  # (현재 위치, 방문 횟수)
    visited = [0] * N        # 방문 여부, 해당 칸 까지의 최소 점프 수 저장
    visited[0] = 0

    # 각 거리에 이동한 값을 저장해두고, 이동했을 때의 최솟값을 찾기
    while queue:
        current_position, move = queue.popleft()

        # 마지막 칸에 도착했다면, 이동 횟수를 반환
        # 위로 올리면 다른 예외처리 필요없이 로직 동작 가능!
        if current_position == N - 1:
            return move

        # 현재 위치에서 갈 수 있는 범위
        max_move = input_list[current_position]
        for i in range(1, max_move + 1):
            next_position = current_position + i

            # 방문하지 않았다면 방문하고 +1
            if next_position < N and visited[next_position] == 0:
                visited[next_position] = move + 1
                queue.append((next_position, move + 1))

    # 마지막 칸에 도달할 수 없는 경우
    return -1

N = int(input())
input_list = list(map(int,input().split()))

print(BFS(N, input_list))