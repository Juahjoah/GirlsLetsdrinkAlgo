package chahyechahye._240704;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ_10451_순열_사이클 {

    
    public static void main(String[] args) throws IOException{
        
        // 1부터 N까지 정수 N개로 이루어진 순열
        // 8개의 수로 이루어진 순열
        // 순열 사이클의 갯수 세는 프로그램

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++) {
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int arr[] = new int[size + 1];
            boolean visited[] = new boolean[size + 1];
            int count = 0;

            for (int j = 1; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= size; j++) {
                if(!visited[j]) {
                    visited[j] = true;
                    int next = arr[j];

                    while (true) {
                        if(visited[next]) {
                            count++;
                            break;
                        }
                        visited[next] = true;
                        next = arr[next];
                    }

                }
            }

            sb.append(count + "\n");

    }

    System.out.println(sb);

}

}