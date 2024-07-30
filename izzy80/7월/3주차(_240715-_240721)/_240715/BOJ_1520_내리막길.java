import java.util.*;
import java.io.*;

public class BOJ_1520_내리막길 {
    static int M,N;
    static int[][] map;
    static int[][] dp;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        //1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //세로
        N = Integer.parseInt(st.nextToken()); //가로

        map = new int[M+1][N+1];
        dp = new int[M+1][N+1];
        for(int i=1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j <=N ;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        // 2. solve & print
        System.out.println(DFS(1,1));
    }

    static public int DFS(int r, int c){
        if(r == M && c == N) return 1; //도착지에 도달했으면 끝
        if(dp[r][c] != -1){//-1이 아니면 이미 방문함
            return dp[r][c];
        }
        else{//-1인 경우 방문 안 함
            dp[r][c] = 0;
            for (int m=0; m<4; m++) {
                int nr = r + mover[m];
                int nc = c + movec[m];
                if (nr < 1 || nr > M || nc < 1 || nc > N) continue;
                if (map[r][c] > map[nr][nc]) {
                    //현재 값이 더 큰 경우
                    dp[r][c] += DFS(nr, nc);
                }
            }
        }
        return dp[r][c];
    }
}
