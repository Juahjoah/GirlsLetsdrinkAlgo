import java.util.*;
import java.io.*;

public class BOJ_23796_2_147_483_648_게임 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 8;
        long[][] map = new long[N][N];
        long[][] new_map = new long[N][N];
        for(int i=0; i < N; i++){
            Arrays.fill(map[i],0);
            Arrays.fill(new_map[i],0);
        }

        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Long.parseLong(st.nextToken());
            }
        }


        String dir = br.readLine(); //방향키
        Queue<Long> q;
        switch (dir){
            case "U" :
                for(int c=0; c < N; c++){
                    q = new LinkedList<>();
                    for(int r = 0; r < N; r++){
                        if(map[r][c] != 0){
                            q.add(map[r][c]);
                        }
                    }
                    //한 줄 끝
                    int idx = 0;
                    while(!q.isEmpty()){
                        long tmp = q.poll();
                        if(q.peek() == null){
                            new_map[idx][c] = tmp;
                        }
                        else{
                            long next = q.peek();
                            if(tmp == next){//같으면
                                new_map[idx++][c] = tmp*2;
                                q.poll();
                            }
                            else{//다르면
                                new_map[idx++][c] = tmp;
                            }
                        }
                    }
                }
                break;
            case "D" :
                for(int c=0; c < N; c++){
                    q = new LinkedList<>();
                    for(int r = N-1; r >= 0; r--){
                        if(map[r][c] != 0){
                            q.add(map[r][c]);
                        }
                    }
                    //한 줄 끝
                    int idx = N-1;
                    while(!q.isEmpty()){
                        long tmp = q.poll();
                        if(q.peek() == null){
                            new_map[idx][c] = tmp;
                            q.poll();
                        }
                        else{
                            long next = q.peek();
                            if(tmp == next){//같으면
                                new_map[idx--][c] = tmp*2;
                                q.poll();
                            }
                            else{//다르면
                                new_map[idx--][c] = tmp;
                            }
                        }
                    }
                }
                break;
            case "L" :
                for(int r=0; r < N; r++){
                    q = new LinkedList<>();
                    for(int c = 0; c < N; c++){
                        if(map[r][c] != 0){
                            q.add(map[r][c]);
                        }
                    }
                    //한 줄 끝
                    int idx = 0;
                    while(!q.isEmpty()){
                        long tmp = q.poll();
                        if(q.peek() == null){
                            new_map[r][idx] = tmp;
                            q.poll();
                        }
                        else{
                            long next = q.peek();
                            if(tmp == next){//같으면
                                new_map[r][idx++] = tmp*2;
                                q.poll();
                            }
                            else{//다르면
                                new_map[r][idx++] = tmp;
                            }
                        }
                    }
                }
                break;
            case "R" :
                for(int r=0; r < N; r++){
                    q = new LinkedList<>();
                    for(int c = N-1; c >= 0; c--){
                        if(map[r][c] != 0){
                            q.add(map[r][c]);
                        }
                    }

                    //한 줄 끝
                    int idx = N-1;
                    while(!q.isEmpty()){
                        long tmp = q.poll();
                        if(q.peek() == null){
                            new_map[r][idx] = tmp;
                            q.poll();
                        }
                        else{
                            long next = q.peek();
                            if(tmp == next){//같으면
                                new_map[r][idx--] = tmp*2;
                                q.poll();
                            }
                            else{//다르면
                                new_map[r][idx--] = tmp;
                            }
                        }
                    }
                }
                break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                sb.append(new_map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
