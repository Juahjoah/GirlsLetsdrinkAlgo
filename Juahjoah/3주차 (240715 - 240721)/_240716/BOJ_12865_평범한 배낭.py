#input 값 받아오기
N, K = map(int, input().split())

# 물건의 무게와 가치를 저장할 리스트 초기화
items = []

# 물건의 무게와 가치를 입력 받아 리스트에 저장한다.
for _ in range(N) :
    W, V = map(int, input().split())
    items.append((W,V))

# DP 테이블 초기화
# DP[i][j]는 첫 i개의 물건 중에서 최대 무게 w를 넘지 않으면서 얻을 수 있는 최대 가치를 저장한다.
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

# 배낭에 넣을 수 있는 물건들의 가치 합의 최댓값 출력
print(DP[N][K])

