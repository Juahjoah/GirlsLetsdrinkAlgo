package chahyechahye._240706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1522_문자열_교환 {

    public static void main(String[] args) throws IOException{
        
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // 총 a의 갯수 중 b가 포함된 갯수의 최솟값 구하기

            String str = br.readLine();
            int countA = 0;

            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == 'a') {
                    countA++;
                }
            }

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < str.length(); i++) {
                int countB = 0;
                for (int j = i; j < i+countA; j++) {
                    int loca = j % str.length();
                    if(str.charAt(loca) == 'b') {
                       countB++;
                    }
            
                }

                min = Math.min(min, countB);
                        
            }

            System.out.println(min);

    }
    
}