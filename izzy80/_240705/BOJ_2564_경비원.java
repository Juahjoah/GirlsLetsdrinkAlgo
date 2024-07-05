import java.util.*;
import java.io.*;

public class BOJ_2564_경비원 {
    static int[] map;
    public static void main(String[] args) throws IOException {
        //1. input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        //상점의 위치
        int store_cnt = Integer.parseInt(br.readLine());
        int cnt =0;
        int police = 0;
        map = new int[store_cnt];

        for(int i=0; i < store_cnt+1; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            int tmp =0;

            switch(dir){
                case 1:
                    tmp = loc;
                    break;
                case 2:
                    tmp = width + length + width - loc;
                    break;
                case 3:
                    tmp = width + length + width + length - loc;
                    break;
                case 4:
                    tmp = width + loc;
                    break;
            }

            // 동근이 위치
            if(i < store_cnt) {
                map[i] = tmp;
            } else {
                police = tmp;
            }
        }

        //solve
        for (int i = 0; i < store_cnt; i++) {
            int path1 = Math.abs(police - map[i]);
            int path2 = 2 * width + 2 * length - path1;
            cnt += Math.min(path1, path2);
        }

        System.out.println(cnt);
    }

}
