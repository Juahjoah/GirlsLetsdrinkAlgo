import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_암호코드_dp {
    static int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //암호가 주어짐. <= 5000
        char[] password = br.readLine().toCharArray();

        // 맨 앞자리가 0이면 잘못된 입력임
        if (password[0] == '0') {
            System.out.println(0);
            return;
        }

        // dp
        int[] dp = new int[password.length+1];
        dp[0] = dp[1] = 1;


        for (int i = 2; i <= password.length; i++) {
            // 한 자릿수 계산했을 때 경우의 수 더하기
            if (password[i-1] != '0') {
                dp[i] += dp[i-1] % MOD;
            }

            // 두 자릿수도 계산 가능하다면 경우의 수 더하기
            int temp = ((password[i-2] - '0') * 10) + password[i-1] - '0';
            if (temp >= 10 && temp <= 26) {
                dp[i] += dp[i-2] % MOD;
            }
        }
        System.out.println(dp[password.length] % MOD);
    }
}
