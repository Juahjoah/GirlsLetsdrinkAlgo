from collections import deque

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

def BFS(R, C, input_arr):
    route_queue = deque()
    fire_queue = deque()
    answer = 0

    # 지훈이, 불의 시작점을 저장
    for i in range(R):
        for j in range(C):
            if input_arr[i][j] == "J":
                route_queue.append((i, j))
            elif input_arr[i][j] == "F":
                fire_queue.append((i, j))

    # 저장된 값을 꺼내서 이동시키기
    while route_queue:
        answer += 1           # 이동 횟수 추가

        # 불의 이동
        for _ in range(len(fire_queue)):
            fx, fy = fire_queue.popleft()
            for d in range(4):
                fnx, fny = fx + dx[d], fy + dy[d]
                # 불 확산
                if 0 <= fnx < R and 0 <= fny < C and input_arr[fnx][fny] == ".":
                    input_arr[fnx][fny] = "F"
                    fire_queue.append((fnx, fny))

        # 지훈이의 이동
        for _ in range(len(route_queue)):
            x, y = route_queue.popleft()
            for d in range(4):
                nx, ny = x + dx[d], y + dy[d]

                if 0 <= nx < R and 0 <= ny < C and input_arr[nx][ny] == "." and input_arr[nx][ny] != "F":
                    input_arr[nx][ny] = "J"
                    # 메모리 초과
                    # input_arr[nx][ny] == "J"
                    route_queue.append((nx, ny))

                # if 0 <= nx < R and 0 <= ny < C:
                #     if input_arr[nx][ny] == ".":
                #         input_arr[nx][ny] = "J"
                #         route_queue.append((nx, ny))

                # 코드 참고
                # 탈출에 성공 = 미로의 경계선을 벗어났다!
                if 0 > nx or nx >= R or 0 > ny or ny >= C:
                    return answer

    return "IMPOSSIBLE"


R, C = map(int, input().split())
input_arr = [list(input().strip()) for _ in range(R)]


print(BFS(R, C, input_arr))


# 처음에는 "for j in range(4):" 하나에 지훈이의 이동과 불의 이동을 한번에 표현하려고 함.
# 이런 경우, 길을 찾지 못하는 경우 등 상황을 추가하기 어렵고, 코드가 복잡해 짐.
# → 각각의 큐마다 로직을 지정하고, 명확하게 구분하여 개별 처리