# 수많은 시도에도 실패를 거듭해 구글링을 통해 다른 사람의 코드를 참고해 구현을 진행함.

from collections import deque

# 상하좌우 이동 
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
INF = 10**6  # 큰 값

# BFS를 통해 각 지점에서 다른 지점까지의 최단 거리를 계산하는 함수
def BFS_shortPath(start, num):
    y, x = start                             # 시작 위치
    visited = [[0] * M for _ in range(N)]    # 방문 여부 체크
    dq = deque([(y, x, 0)])                  # BFS를 위한 큐, (y, x, 거리) 저장

    while dq:
        y, x, d = dq.popleft()
        if visited[y][x]:
            continue
        visited[y][x] = 1
        if room[y][x] == "*":                    # 더러운 칸을 찾았을 때
            n1 = numdict[(y, x)]                 # 해당 칸의 번호
            graph[num][n1] = graph[n1][num] = d  # 그래프에 거리 저장
        for i in range(4):                       # 상하좌우 탐색
            ny, nx = y + dy[i], x + dx[i]
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and room[ny][nx] != "x":
                dq.append((ny, nx, d + 1))       # 이동 가능한 경우 큐에 추가

# DFS를 통해 최소 거리를 탐색하는 함수
def DFS(now, distance, cnt):
    global result
    if distance >= result:                       # 현재 거리가 최종 결과보다 크거나 같으면 중단
        return
    if cnt == num:                               # 모든 더러운 칸을 방문했을 때
        result = min(result, distance)           # 최소 거리 업데이트
        return
    for next in range(1, num + 1):               # 다음 방문할 칸 탐색
        if not visited[next]:
            visited[next] = 1
            DFS(next, distance + graph[now][next], cnt + 1)  # 재귀 호출
            visited[next] = 0

# 메인 루프
while True:
    M, N = map(int, input().split())              # 방의 가로, 세로 크기 입력
    if not N:
        break

    room = [list(input().strip()) for _ in range(N)]  # 방의 상태 입력

    numdict = {}                                      # 더러운 칸의 번호를 저장할 딕셔너리
    dirty = {}                                        # 더러운 칸의 위치를 저장할 딕셔너리
    num = 0                                           # 더러운 칸의 개수
    for y in range(N):
        for x in range(M):
            if room[y][x] == "o":
                robot = (y, x)                        # 로봇의 시작 위치
            elif room[y][x] == "*":
                num += 1
                numdict[(y, x)] = num                 # 더러운 칸 번호 할당
                dirty[num] = (y, x)                   # 더러운 칸 위치 저장

    result = INF                                         # 최종 결과값을 초기화
    graph = [[INF] * (num + 1) for _ in range(num + 1)]  # 거리 그래프 초기화
    BFS_shortPath(robot, 0)                              # 로봇의 시작 위치에서 BFS 실행
    
    for i in range(1, num + 1):                          # 모든 더러운 칸에 대해 연결 여부 확인
        if graph[0][i] == INF:
            result = -1
            break
    if result == -1:
        print(-1)
        continue

    for i in range(1, num + 1):
        BFS_shortPath(dirty[i], i)                       # 각 더러운 칸에서 BFS 실행

    visited = [0] * (num + 1)       # 방문 여부 배열 초기화
    DFS(0, 0, 0)                    # DFS 실행
    print(result)                   # 최종 결과 출력

# ----------------------------------------------------------------------------
'''
- BFS를 사용
    - 더러운 칸의 개수가 많지 않기 때문에, 각 더러운 칸 사이의 최단 거리를 미리 계산함.

- DFS를 사용
    - 모든 더러운 칸을 방문하는 경로 중 이동 횟수가 가장 적은 경로를 찾아 DFS를 사용
    - 현재까지의 경로 길이가 이미 저장한 경로 경로 길이보다 커지면 탐색을 중단

'''
# ----------------------------------------------------------------------------

# 최초의 풀이
# 전체 상황을 탐색하고, 그 중 가장 작은 수의 이동 경로를 추출
# 실패 사유 : 메모리 초과
'''
from collections import deque

# 상하좌우
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

# 가능한 모든 경로 탐색하기
def BFSAllPath(W, H, inputArr, start, cleanPositions):
    queue = deque([(start, 0, set())])
    answerList = []

    while queue:
        (x, y), count, cleaned = queue.popleft()

        if (x, y) in cleanPositions:
            cleaned = cleaned | {(x, y)}

        if len(cleaned) == len(cleanPositions):
            answerList.append(count)
            continue
        # 이동하며 탐색하기
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < H and 0 <= ny < W and inputArr[nx][ny] != "x":
                queue.append(((nx, ny), count+1, cleaned))

    return answerList


def BFS(W, H, inputArr):
    start = None

    # 방문할 곳을 담을 배열
    cleanPositions = []

    for i in range(H):
        for j in range(W):
            if inputArr[i][j] == "o":
                start = (i, j)
            elif inputArr[i][j] == "*":
                cleanPositions.append((i, j))

    # 더러운 칸이 없다면,
    if not cleanPositions:
        return 0

    answerList = BFSAllPath(W, H, inputArr, start, cleanPositions)

    if answerList:
        return min(answerList)
    else:
        return -1

# input 값 받아오기
while True:
    W, H = map(int, input().split())
    if W == 0 or H == 0:
        break

    inputArr = [list(input().strip()) for _ in range(H)]

    print(min(BFS(W, H, inputArr)))

'''

# 두번째+a 풀이
# DFS를 추가해 거리 탐색을 진행함.
# 실패