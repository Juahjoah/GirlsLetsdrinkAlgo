from collections import deque

def BFS():
    queue = deque()
    queue.append((0, 0))

    answer = 0

    # 탐색
    while queue:
        days, score = queue.popleft()

        # 완료 처리
        if days == N:
            if answer < score:
                answer = score
            continue

        # 상담 잡기
        if days + input_list[days][0] <= N:
            queue.append((days + input_list[days][0], score + input_list[days][1]))
        # 상담 안 잡기
        queue.append((days + 1, score))

    return answer


N = int(input())
input_list = [list(map(int, input().split())) for _ in range(N)]

print(BFS())