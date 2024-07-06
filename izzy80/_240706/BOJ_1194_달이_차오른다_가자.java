import java.util.*;
import java.io.*;
/**
 * 민식 : 미로(직사각형) 속에 있음
 * 여행을 떠나기 위해 미로를 탈출해야함.
 *
 * . : 빈칸, 이동O
 * # : 벽, 이동X
 * a,b,c,d,e : 열쇠, 이동o
 * A,B,C,D,E : 문, 얄쇠가 있다면 이동o
 * O : 민식이의 위치
 * 1 : 출구
 *
 * 움직이는 것은 수직, 수평으로 1칸이동
 * 이동 횟수의 최솟값은? => BFS???
 * 탈출할 수 없으면 -1
 *
 * 열쇠는 여러번 사용할 수 있다.
 * 위치(0)은 한개 있다.
 * 출구(1)은 적어도 한 개 있다.
 * 갔던 곳 또 가는 것 가능
*/

class Node{
    int r;
    int c;
    int dist;
    int key;

    Node(int r, int c, int dist, int key){
        this.r = r;
        this.c = c;
        this.dist = dist;
        this.key = key;
    }

}

public class BOJ_1194_달이_차오른다_가자 {
    static int N,M;
    static char[][] map;
    static boolean[][][] visited; // a~f까지 키 소유 여부
    static int[] mover = {0,0,-1,1};
    static int[] movec = {-1,1,0,0};
    static int ans = -1;
    public static void main(String[] args) throws IOException{
        //1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        map = new char[N][M];
        visited = new boolean[N][M][64];

        int startr = 0; //민식의 위치
        int startc = 0;

        for(int i=0; i < N; i++){
            String tmp = br.readLine();
            for(int j=0; j < M;j++){
                char c = tmp.charAt(j);
                map[i][j] = c;
                if(c == '0'){
                    startr = i;
                    startc = j;
                }
            }
        }

        //2. solve
        BFS(startr, startc);



        //3. print
        System.out.println(ans);
    }

    static public void BFS(int r, int c){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c,0,0));
        visited[r][c][0] = true;
        map[r][c] = '.';

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(map[cur.r][cur.c] == '1') {//출구 도착
                ans = cur.dist;
                return;
            }

            for(int m =0; m <4 ;m++){
                int nr = cur.r+mover[m];
                int nc = cur.c+movec[m];
                //1. 이동 불가
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(map[nr][nc] == '#' || visited[nr][nc][cur.key]) continue;
                //2. 이동 가능
                if(map[nr][nc] >= 'a' && map[nr][nc] <= 'z'){//열쇠라면
                    int key = cur.key | (1 << map[nr][nc] - 'a');
                    q.add(new Node(nr,nc,cur.dist+1, key));
                    visited[nr][nc][key] = true;
                }
                else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {  //문이라면
                    boolean flag = (cur.key & (1 << (map[nr][nc] - 'A'))) != 0; // 키 존재하는지 체크
                    if (flag) { // 키 존재할 경우
                        q.offer(new Node(nr, nc, cur.dist + 1, cur.key));
                        visited[nr][nc][cur.key] = true;
                    }
                }
                else { //.이나 도착지
                    q.offer(new Node(nr, nc, cur.dist + 1, cur.key));
                    visited[nr][nc][cur.key] = true;
                }
            }
        }

    }
}
