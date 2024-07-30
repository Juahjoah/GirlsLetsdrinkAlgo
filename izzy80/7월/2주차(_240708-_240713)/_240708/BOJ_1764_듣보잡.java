import java.util.*;
import java.io.*;

/*
듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성
듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
 */
public class BOJ_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> tm = new TreeMap<>();
        for(int i=0; i < N+M; i++){
            String str = br.readLine();
            tm.put(str, tm.getOrDefault(str, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(String key : tm.keySet()){
            if(tm.get(key) == 2){
                cnt++;
                sb.append(key).append("\n");
            }
        }

        //print
        System.out.println(cnt);
        System.out.println(sb);
    }
}
