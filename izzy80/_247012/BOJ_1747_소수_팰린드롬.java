import java.util.*;
import java.io.*;

public class BOJ_1747_소수_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb;
        for(int i=N; ; i++){
            if(isPrime(i)){
                //팰린드롬인지 판단
                String origin = String.valueOf(i);
                sb = new StringBuilder();
                sb.append(origin).reverse();
                String num = sb.toString();
                if(origin.equals(num)){
                    System.out.println(num);
                    break;
                }
            }
        }
    }

    static public boolean isPrime(int num){
        if(num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
