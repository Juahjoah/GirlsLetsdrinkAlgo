import java.util.*;
import java.io.*;
/*회고
1. 자료 구조 다시 한 번 생각해보기
2. 다시 한 번 풀어보기
*/

public class baek20056_마법사상어와파이어볼 {
    static int N,M,K; //크기, 파이어볼 갯수, 이동 명령 횟수
    static ArrayList<Info>[][] map;
    static ArrayList<Info> fireball = new ArrayList<>();
    static int[] mover = {-1,-1,0,1,1,1,0,-1}; //방향 0~7
    static int[] movec = {0,1,1,1,0,-1,-1,-1};

    static class Info{
        int r;
        int c;
        int m;
        int s;
        int d;

        public Info(int r, int c, int m, int s, int d){
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d =d;
        }

    }
    public static void main(String[] args) throws IOException {
        //1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            //파이어볼 정보
            //위치는 1번부터 시작 -> -1해주는 이유
            int r = Integer.parseInt(st.nextToken()) - 1; //행
            int c = Integer.parseInt(st.nextToken()) - 1; //열
            int m = Integer.parseInt(st.nextToken()); //질량
            int s = Integer.parseInt(st.nextToken()); //속력
            int d = Integer.parseInt(st.nextToken()); //방향

            //fireball에 추가
            fireball.add(new Info(r, c, m, s, d));
        }

        //2. 명령
        for (int i = 0; i < K; i++) {
            //2-1. 파이어볼 이동
            moveFireBall();
            //2-2. 이동 끝난 후에
            doFireBall();
        }

        // 3. 파이어볼 질량의 합
        int answer = 0;
        for (Info fire : fireball){
            answer += fire.m;
        }
        // 4. 출력
        System.out.println(answer);

    }

    public static void moveFireBall(){
        for(Info fire : fireball){
            //N을 나누는 이유는 문제에서 >1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있다<라고 함.
            int nr = (fire.r+N+mover[fire.d]*(fire.s%N)) % N;
            int nc = (fire.c+N+movec[fire.d]*(fire.s%N)) % N;
            fire.r = nr;
            fire.c = nc;
            //이동한 파이어볼 저장
            map[nr][nc].add(fire);
        }
    }

    public static void doFireBall(){
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(map[i][j].size() < 2){
                    //2보다 작을 때는 아무것도 안 함
                    map[i][j].clear();
                    continue;
                }
                int size = map[i][j].size();
                int m_sum = 0;//질량
                int s_sum = 0; //속력
                int cnt =0; // 홀수, 짝수인지 cnt

                for(Info fire : map[i][j]){
                    m_sum+=fire.m;
                    s_sum+=fire.s;
                    if(fire.d %2 == 0) cnt++;
                    fireball.remove(fire); //분열된 것 제거
                }

                //4개로 쪼개기
                map[i][j].clear();
                m_sum /= 5;
                if(m_sum == 0) continue;
                s_sum /= size;
                for(int k=0; k< 4; k++) {
                    if (cnt == 0 || cnt == size) { //모두 홀수이거나 짝수
                        fireball.add(new Info(i, j, m_sum, s_sum, k * 2));
                    } else {
                        fireball.add(new Info(i, j, m_sum, s_sum, (k * 2) + 1));
                    }

                }
            }
        }
    }
}
