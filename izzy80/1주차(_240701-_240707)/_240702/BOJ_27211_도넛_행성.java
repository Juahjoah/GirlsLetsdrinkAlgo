import java.util.*;
import java.io.*;

/*
* 문제 풀이 BFS
* */
public class baek27211_도넛행성 {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //solve
        int ans = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j< M; j++){
                if(map[i][j] == 0 && !visited[i][j]){
                    //숲이 아니면서 방문한 적 없는 곳
                    BFS(i,j);
                    ans++;
                }
            }
        }
//        System.out.println(Arrays.deepToString(visited));


        //print
        System.out.println(ans);
    }

    static public void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int m = 0; m < 4; m++){
                //다시 되돌아오는 경우 고려
                int nr = (tmp[0]+mover[m]+N)%N;
                int nc = (tmp[1]+movec[m]+M)%M;

                if(map[nr][nc] == 1) continue; //숲이면 못 지나감
                if(visited[nr][nc]) continue; //방문했다면 지나감
                q.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }

    }
}
