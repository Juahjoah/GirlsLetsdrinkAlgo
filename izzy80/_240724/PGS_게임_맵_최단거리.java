import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int N,M;
    static int[] mover = new int[]{-1,0,1,0};
    static int[] movec = new int[]{0,1,0,-1};
    static int[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        
        visited = new int[N][M];
        BFS(maps);
        if(visited[N-1][M-1] == 0){
            answer = -1;
        }
        else{
            answer = visited[N-1][M-1];
        }
        // System.out.println(Arrays.deepToString(visited));
        return answer;
    }
      private void BFS(int[][] maps) {
            Queue<int []> q = new LinkedList<>();
            q.add(new int[]{0,0});
            visited[0][0] = 1;

            while(!q.isEmpty()){
                int[] tmp = q.poll();
                int cr = tmp[0];
                int cc = tmp[1];

                for(int m =0; m< 4;m++){
                    int nr = cr + mover[m];
                    int nc = cc + movec[m];

                    if(nr <0 || nr >= N || nc <0 || nc>= M) continue;
                    if(visited[nr][nc] > 0 || maps[nr][nc] == 0) continue;
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = visited[cr][cc]+1;
                }
            }

        }
}