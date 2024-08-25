package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2003_수들의_합_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        int ans = 0;

        int start = 0;
        int end = 0;
        int sum = 0;
        while(true){
            if(sum >= M){
                sum -= arr[start++];
            }
            else if(end == N) break;
            else{
                sum += arr[end++];
            }
            if(sum == M) ans++;
        }

        System.out.println(ans);

    }
}
