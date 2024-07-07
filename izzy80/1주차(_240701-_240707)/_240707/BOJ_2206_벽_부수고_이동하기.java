import java.util.*;
import java.io.*;
/*
0 : 이동O
1 : 벽, 이동X
(1,1) -> (N,M) 최단경로 이동 => BFS
시작하는 칸과 끝나는 칸도 센다.
벽 한 개까지는 부숴도 괜찮다.
부숨. 안 부숨 -> visited[][][]
이동할 수 있는 칸은 상하좌우 1칸씩
 */
public class BOJ_2206_벽부수고이동하기 {
    static int N,M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static int ans = -1; //출력 불가능시


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i < N; i++){
            String tmp = br.readLine();
            for(int j=0; j < M; j++){
                map[i][j] = tmp.charAt(j)-'0';
            }
        }

        //solve
        BFS();

        //print
        System.out.println(ans);


    }

    static public void BFS(){
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][M][2];
        q.add(new int[]{0,0,1,0}); //0이면 벽 부수지X, 1이면 벽 부숨
        // r,c, dist, 벽을 부쉈는지 아닌지
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0] == N-1 && tmp[1] == M-1){
                ans = tmp[2];
                return;
            }

            for(int m=0; m < 4; m++){
                int nr = tmp[0]+mover[m];
                int nc = tmp[1]+movec[m];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue; //범위 벗어나면 못 지나감
                if(map[nr][nc] == 0 && !visited[nr][nc][tmp[3]]){
                    q.add(new int[]{nr, nc, tmp[2]+1, tmp[3]});
                    visited[nr][nc][tmp[3]] = true;
                }
                else {//벽일 때
                    if(tmp[3] == 0 && !visited[nr][nc][tmp[3]+1]){//tmp[3] = 0이면 벽 부순적 없음
                        q.add(new int[]{nr, nc, tmp[2]+1, tmp[3]+1});
                        visited[nr][nc][tmp[3]+1] = true;
                    }
                }
            }
        }



    }
}
