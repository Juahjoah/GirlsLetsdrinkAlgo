
# 보드에서 같은 색 뿌요를 찾아서 삭제
# 뿌요를 없앴다면, 중력에 따라 보드를 재정렬


dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

# 같은 색 뿌요를 찾을 함수
def BFS(cx, cy, visited):
    same_puyo_list = [(cx, cy)]
    queue = [(cx, cy)]
    visited[cx][cy] = True

    while queue:
        x, y = queue.pop()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < 12 and 0 <= ny < 6 and input_list[x][y] == input_list[nx][ny] and visited[nx][ny] == False:
                visited[nx][ny] = True                              # 방문처리
                same_puyo_list.append((nx, ny))
                queue.append((nx, ny))

    return same_puyo_list


# 같은 색 뿌요를 삭제
def boom():
    flag = False                                # 뿌요가 터졌는지 여부를 판단하기 위한 변수

    visited = [[0]*6 for _ in range(12)]        # 방문 여부를 체크하기 위한 리스트
    for i in range(12):             
        for j in range(6):          
            if input_list[i][j] == ".":         
                continue                        # 빈 공간은 패스

            same_puyo_list = BFS(i, j, visited) # 현재 위치와 방문한 값을 넘겨주기

            # 만약 동일한 색이 4개 이상 모여있다면,
            if len(same_puyo_list) >= 4:    
               flag = True                      # 뿌요가 터졌다는 표시
               for x, y in same_puyo_list:      # 터진 뿌요들을 "."으로 변경  
                   input_list[x][y] = "."

    return flag                                 # 앞으로 진행 여부를 반납



# 보드를 중력에 의해서 재정비하는 함수
# 포인트! 아래에서 위로 for문을 탐색. 빈 공간과 문자값의 자리를 변경해 줌.
def gravity():
    for j in range(6):
        i = 11                                      # 역순으로 파악하기 위함.
        while i > 0:
            if input_list[i][j] == ".":
                for height in range(i-1, -1, -1 ):  # 역으로 for문
                    if input_list[height][j] != ".":
                        input_list[i][j], input_list[height][j] = input_list[height][j], input_list[i][j]
                        break

                else:
                    break                           # while 문을 종료 = 위의 공간은 어차피 빈 공간!

            i -= 1


# input_list = list(input().strip() for _ in range(12))
input_list = list(list(input()) for _ in range(12))
answer = 0

while boom():
    gravity()
    answer += 1

print(answer)

# for - else문 : 정상 순회한다면, else문으로 내려감. for문에서 break로 그냥 빠져나간다면, else문 생략