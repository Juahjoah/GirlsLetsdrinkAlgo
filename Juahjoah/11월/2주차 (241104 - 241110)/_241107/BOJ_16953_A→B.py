from collections import deque

A, B = map(int, input().split())

def multiply(num):
    num = num * 2
    return num

def plus(number):
    number = number * 10 + 1
    return number

def BFS(n):
    queue = deque()
    queue.append((n, 0))

    visited = set()
    # visited = [0]*(B+1)

    while queue:
        x, cnt = queue.popleft()

        if x == B:
            return cnt + 1

        # 아직 B에 도달하지 못한 경우 계속해서 숫자를 변경해줘야함.
        # if multiply(x) <= B and visited[multiply(x)] == 0:
        if 1 <= multiply(x) <= 10 ** 9 and multiply(x) not in visited:
            queue.append((multiply(x), cnt+1))
            visited.add(multiply(x))
        # if plus(x) <= B and visited[plus(x)] == 0:
        if 1 <= plus(x) <= 10 ** 9 and plus(x) not in visited:
            queue.append((plus(x), cnt+1))
            visited.add(plus(x))

    return -1

print(BFS(A))


# 1. visited 배열을 set으로 변경
# 2. not in visited로 변경
# 3. 매우 큰 정수가 들어오는 경우, stack overflow가 발생할 수 있으므로, 10^9로 제한