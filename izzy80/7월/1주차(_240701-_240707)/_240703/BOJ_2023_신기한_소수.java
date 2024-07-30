import java.util.*;
import java.io.*;

/**
 * 왼쪽부터 1자리, 2자리, 3자리, 4자리...다 소수일때
 */
public class BOJ_2023_신기한_소수 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //풀이
        solve(0,N);
        //출력
        System.out.println(sb);
    }

    static public void solve(int result, int n){
        if(n ==0){
            if(isPrime(result)) sb.append(result).append("\n");
            return;
        }
        for(int i=0; i< 10; i++){
            int next = result*10+i;
            if(isPrime(next)) solve(next, n-1);
        }
    }

    static public boolean isPrime(int num){
        //에라토스테네스의 체
        if (num < 2) return false;
        for(int i=2; i<=Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
