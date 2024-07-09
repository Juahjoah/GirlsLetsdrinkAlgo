import java.util.*;
import java.io.*;

/**
 * B : 파란색 (적국 병사)
 * W : 흰색 (내 병사)
 *
 * 내 병사의 위력의 합. 적국 병사의 위력의 합
 */
public class BOJ_1303_전쟁_전투 {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int cnt;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i=0; i< M; i++){
            String str = br.readLine();
            for(int j=0; j < N; j++){
                map[i][j] = str.charAt(j);
            }
        }

        //solve
        int wscore = 0;
        int bscore = 0;
        for(int i=0; i < M; i++){
            for(int j=0; j < N; j++){
                if(!visited[i][j]){
                    BFS(i,j);
                    if(map[i][j] == 'W'){
                        wscore += Math.pow(cnt,2);
                    }
                    else{
                        bscore += Math.pow(cnt,2);
                    }
                }
            }
        }

        //print
        System.out.println(wscore+" "+bscore);
    }

    static public void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        cnt = 0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            cnt++;
            for(int m=0; m < 4; m++){
                int nr = tmp[0] + mover[m];
                int nc = tmp[1] + movec[m];

                if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[r][c] != map[nr][nc]) continue;
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
    }
}
