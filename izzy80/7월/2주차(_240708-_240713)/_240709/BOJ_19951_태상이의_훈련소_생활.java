import java.util.*;
import java.io.*;

/**
 * k >=0 a번칸부터 b번칸까지 높이가 각각 |k|만큼 늘어나도록 흙을 덮는다.
 * k < 0 a번칸부터 b번칸까지 높이가 각각 |k|만큼 줄어들도록 흙을 덮는다.
 */
public class BOJ_19951_태상이의_훈련소_생활 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //연병장의 크기
        int M = Integer.parseInt(st.nextToken()); //조교의 수

        //연병장 각 칸의 높이
        int[] H = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i <= N; i++){
            H[i] = Integer.parseInt(st.nextToken());
        }

        //조교의 지시
        int[] sum = new int[N+2];
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            //누적합
            sum[a] += k;
            sum[b+1] -= k;
        }
        for(int i =1;i<=N;i++){
            sum[i] += sum[i-1];
            H[i] +=sum[i];
        }

        //print
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= N; i++){
            sb.append(H[i]).append(" ");
        }

        System.out.println(sb);
    }
}
