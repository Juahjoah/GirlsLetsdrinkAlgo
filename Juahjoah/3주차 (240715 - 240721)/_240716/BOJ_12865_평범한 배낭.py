#input 값 받아오기
N, K = map(int, input().split())

# input 값을 담을 배열
items = []

# input 값 받아오기
for _ in range(N) :
    W, V = map(int, input().split())
    items.append((W,V))

# DP 테이블 만들기
DP = [[0] * (K+1) for _ in range(N+1)] 

# DP 테이블 채우기
for i in range(1, N+1):
    W, V = items[i-1]
    for j in range(K+1):
        # 물건을 넣거나, 넣지 않는 경우 중 더 큰 값을 저장한다.
        if j >= W:
            DP[i][j] = max(DP[i-1][j], DP[i-1][j-W] + V)
        else:
            DP[i][j] = DP[i-1][j]

print(DP[N][K])