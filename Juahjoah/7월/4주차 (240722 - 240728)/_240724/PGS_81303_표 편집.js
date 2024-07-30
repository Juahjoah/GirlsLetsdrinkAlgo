//  2021 카카오 채용연계형 인턴십
// 본 문제는 정확성과 효율성 테스트 각각 점수가 있는 문제

function solution(n, k, cmd) {
    let answer = Array(n).fill('O');

    // 스택을 사용하여 삭제된 행을 저장
    let removedStack = [];

    // 현재 행
    let curr = k;

    let prev = Array.from({length: n}, (_, i) => i - 1);
    let next = Array.from({length: n}, (_, i) => i + 1);
    // 마지막 행 이후의 값은 존재하지 않음
    next[n - 1] = -1; 

    cmd.forEach(command => {
        if (command.startsWith("C")) {
            // 현재 행 삭제
            removedStack.push([curr, prev[curr], next[curr]]);
            // 현재 행을 'X'로 변경
            answer[curr] = 'X';

            // 이전 행의 다음 인덱스를 현재 행의 다음 인덱스로 변경
            if (prev[curr] !== -1) {
                next[prev[curr]] = next[curr];
            }
            // 다음 행의 이전 인덱스를 현재 행의 이전 인덱스로 변경
            if (next[curr] !== -1) {
                prev[next[curr]] = prev[curr];
            }

            // 현재 행 업데이트
            // 다음 행이 있는 경우, 이동
            if (next[curr] !== -1) {
                curr = next[curr];
            } else {  // 없는 경우, 현재 행을 이전 행으로 이동
                curr = prev[curr];
            }

        } else if (command.startsWith("Z")) {
            // 가장 최근에 삭제된 행 복구
            const [r, p, n] = removedStack.pop();
            // 복구된 행을 'O'로 변경
            answer[r] = 'O';

            // 복구된 행의 이전 인덱스를 이전 행의 인덱스로 변경
            if (p !== -1) {
                next[p] = r;
            } 
            // 복구된 행의 다음 인덱스를 다음 행의 인덱스로 변경
            if (n !== -1) {
                prev[n] = r;
            }

        } else {
            // 선택한 행 이동
            // 이동할 값 추출
            const [direction, X] = command.split(" ");
            const steps = parseInt(X);
            if (direction === "U") {
                for (let i = 0; i < steps; i++) {
                    curr = prev[curr];  // 현재 행을 이전 행으로 이동
                }
            } else if (direction === "D") {
                for (let i = 0; i < steps; i++) {
                    curr = next[curr];  // 현재 행을 다음 행으로 이동
                } 
            }
        }
    });

    return answer.join('');
};

