import java.util.*;

class Solution {
    public int solution(int[] order) {
  int answer = 0;

            //상자 수 만큼 main_belt에 집어넣기.
            Queue<Integer> main_belt = new LinkedList<>();
            for(int i=1; i <= order.length; i++){
                main_belt.add(i);
            }
            //보조 벨트 생성
            Stack<Integer> sub_belt = new Stack<>();

            //solve 
            int idx = 0;  // order 배열의 인덱스
            while (idx < order.length) {
                if (!main_belt.isEmpty() && main_belt.peek() == order[idx]) {
                    // 메인 벨트에서 바로 트럭으로 상자를 옮김
                    main_belt.poll();
                    answer++;
                    idx++; //해당 order 해결완료했으므로 
                } else if (!sub_belt.isEmpty() && sub_belt.peek() == order[idx]) {
                    // 보조 벨트에서 트럭으로 상자를 옮김
                    sub_belt.pop();
                    answer++;
                    idx++; //해당 order 해결완료했으므로 
                } else if (!main_belt.isEmpty()) {
                    // 메인 벨트의 상자를 보조 벨트로 이동
                    sub_belt.push(main_belt.poll());
                } else {
                    // 더 이상 옮길 수 있는 상자가 없는 경우
                    break;
                }
            }

            return answer;
    }
}