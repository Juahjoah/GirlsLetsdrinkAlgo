import java.util.*;
import java.io.*;

public class BOJ_11000_강의실_배정 {
    static class Lecture {
        int start;
        int end;

        public Lecture(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];
        StringTokenizer st;
        Lecture[] lectures = new Lecture[N];
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start,end);
        }

        //solve -> greedy
        //시작 시간을 기준으로 오름차순
        //시작 시간이 같다면 끝나는 시간을 기준으로 오름차순
        //끝나는 시간을 기준으로 하지 않는 이유 -> 반례 나올 수 있다.
        Arrays.sort(lectures,(o1,o2) -> {
            if(o1.start == o2.start){
                return o2.end - o2.end;
            }
            return o1.start - o2.start;
        });

        //우선순위큐에는 종료시간만 들어가고, 오름차순으로 자동정렬이 됨.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures[0].end);

        for(int i=1; i < N; i++){
            if(pq.peek() <= lectures[i].start){
                //우선순위큐의 종료시간이 시작시간보다 작으면 
                pq.poll();
            }
            pq.offer(lectures[i].end);//끝나는 시간 추가
        }


        //print
        //남은 pq의 size가 답이다.
        System.out.println(pq.size());
    }
}
