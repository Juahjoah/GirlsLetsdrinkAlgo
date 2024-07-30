# 2021 카카오 채용연계형 인턴십
# 본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제
# 참고 (https://wikidocs.net/223108)

def solution(n, k, cmd):
    # 초기 테이블 값을 'O'로 설정
    answer = ['O'] * n

    # 스택을 사용하여 삭제된 행을 저장
    removedStack = []

    # 현재 행
    curr = k

    # 이전, 다음 인덱스
    prev = [i - 1 for i in range(n)]
    next = [i + 1 for i in range(n)]

    # 마지막 행 이후의 값은 존재하지 않음
    next[-1] = -1

    for command in cmd:
        # 삭제
        if command[0] == "C":
            # 현재 행 정보를 스택에 저장 (현재 행, 이전 행, 다음 행)
            removedStack.append((curr, prev[curr], next[curr]))
            # 현재 행을 'X'로 표시하여 삭제 처리
            answer[curr] = 'X'

            # 이전 행의 다음 인덱스를 현재 행의 다음 인덱스로 변경
            if prev[curr] != -1:
                next[prev[curr]] = next[curr]
            # 다음 행의 이전 인덱스를 현재 행의 이전 인덱스로 변경
            if next[curr] != -1:
                prev[next[curr]] = prev[curr]

            # 현재행 업데이트
            # 다음 행이 있는 경우 이동
            if next[curr] != -1:
                curr = next[curr]
            # 다음 행이 없는 경우, 현재 행을 이전 행으로 이동
            else:
                curr = prev[curr]

        # 복구
        elif command[0] == "Z":
            # 스택에서 가장 마지막에 삭제된 값의 정보 복구
            r, p, n = removedStack.pop()
            # 복구된 행에 대한 표기를 변경
            answer[r] = 'O'

            # 이전 행이 있는 경우, 이전 행의 다음 인덱스를 복구된 행으로 변경
            if p != -1:
                next[p] = r
            # 다음 행이 있는 경우, 다음 행의 이전 인덱스를 복구된 행으로 변경
            if n != -1:
                prev[n] = r

        # 선택
        elif command[0] == "U":
            # 이동할 값 추출
            X = int(command.split()[1])
            # X칸 위로 이동
            for _ in range(X):
                curr = prev[curr]

        elif command[0] == "D":
            X = int(command.split()[1])
            # X칸 아래로 이동
            for _ in range(X):
                curr = next[curr]

    return ''.join(answer)