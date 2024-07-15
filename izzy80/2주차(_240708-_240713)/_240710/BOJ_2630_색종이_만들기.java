import java.util.*;
import java.io.*;

public class BOJ_2630_색종이_만들기 {
    static int N;
    static int[][] map;
    static int blue_cnt = 0;
    static int white_cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //solve
        DFS(N, 0,0);

        //print
        System.out.println(white_cnt);
        System.out.println(blue_cnt);
    }

    static public void DFS(int size, int r, int c){
        //색 검증
        if(check(size, r,c)){
            int whiteBlue = map[r][c];
            if(whiteBlue == 1) blue_cnt++;
            else white_cnt++;
            return;
        }

        //4개로 쪼개기
        int new_size = size/2;
        DFS(new_size, r, c); //왼쪽 위
        DFS(new_size, r,c+new_size); //오른쪽 위
        DFS(new_size, r+new_size, c); //왼쪽 아래
        DFS(new_size, r+new_size, c+new_size); //오른쪽 아래
    }

    static public boolean check(int size, int r, int c){
        //파란색 흰색 체크
        int first = map[r][c];
        for(int i = r; i < r+size; i++){
            for(int j = c; j < c+size; j++){
                if(first != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
