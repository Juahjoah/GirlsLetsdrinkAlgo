# Python에 익숙해지기 위한 문제 풀이 (간단한 것부터 풀어갈 예정!)

# 백준 1181번 문제
# 단어 정렬

# input 값 받아오기
N = int(input())
inputArr = [input() for _ in range(N)]

# 중복을 제거한 후에 저장
setArr = list(set(inputArr))

# 단어 길이와 단어를 담는 배열을 생성하고 정보 담기
sortArr = []
for i in setArr :
    sortArr.append([len(i), i])

# 배열 정렬
sortArr.sort()

for j in range(len(sortArr)) :
    print(sortArr[j][1])