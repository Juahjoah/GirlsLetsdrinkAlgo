
# input 값 받아오기
N, M = map(int, input().split())
# inputArr = [list(input().split()) for _ in range(N)]
inputArr = [input() for _ in range(N)]

# 결과를 담을 빈 배열 -> 원하는 건 최소 변경 횟수 = 결과 중에 최솟값 찾기
result = []

# input 체스판 전체를 돌면서 확인하기
for i in range(N-7):
    for j in range(M-7):

        countW = 0
        countB = 0

        # 8*8로로나눈 그 체스판만 확인하기
        for a in range(i, i + 8):  # i부터 i+8까지의 행을 순회
            for b in range(j, j + 8):  # j부터 j+8까지의 열을 순회
                if (a + b) % 2 == 0:  # 행과 열의 합이 짝수인 경우 (체스판의 색상 패턴에 따라)
                    if inputArr[a][b] != "W":   # 현재 위치의 색상이 흰색이 아니면
                        countW += 1             # "W"로 시작하는 체스판 패턴에서 변경 횟수 증가
                    if inputArr[a][b] != "B":   # 현재 위치의 색상이 검은색이 아니면
                        countB += 1             # "B"로 시작하는 체스판 패턴에서 변경 횟수 증가
                else:  # 행과 열의 합이 홀수인 경우
                    if inputArr[a][b] != "B":   # 현재 위치의 색상이 검은색이 아니면
                        countW += 1             # "W"로 시작하는 체스판 패턴에서 변경 횟수 증가
                    if inputArr[a][b] != "W":   # 현재 위치의 색상이 흰색이 아니면
                        countB += 1             # "B"로 시작하는 체스판 패턴에서 변경 횟수 증가

        # "W"로 시작하는 패턴과 "B"로 시작하는 패턴의 변경 횟수를 결과 리스트에 추가
        result.append(countW)
        result.append(countB)

print(min(result))