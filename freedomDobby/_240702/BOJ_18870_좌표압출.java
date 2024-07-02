import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 배열 선언
        int[] arr = new int[n];
        int[] brr = new int[n];

        // 배열 입력 받기
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++) if(arr[i] > arr[j]) cnt++;
            brr[i] = cnt;
            cnt = 0;
        }
        
        // brr 출력
        for(int i = 0; i < brr.length; i++){
            System.out.print(brr[i] + " ");
        }
    }
}
