import java.util.*;
import java.io.*;

/*
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
DFS 이용
자료구조는 인접행렬과 인접리스트가 있음.
인접리스트는 ArrayList<>[]가 있고 ArrayList<ArrayList<Integer>>로 사용할 수 있는데 
이번에는 후자로 사용해서 풀어봄
BFS로 푸는 방법도 있는데 이런 문제는 DFS로 푸는 게 익숙해서 DFS로 풀음
다음에는 BFS로 풀어봐야겠다. 
*/
public class BOJ_2606_바이러스 {
    static int N;
    static int pair_cnt;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //컴퓨터의 수
        pair_cnt = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i=0; i < N+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i < pair_cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        DFS(1);

        //solve
        int ans = 0;
        for(int i=1; i <= N; i++){
            if(visited[i]) ans++;
        }
        System.out.println(ans-1); //1번 컴퓨터 제외
    }

    static public void DFS(int idx){

        visited[idx] = true;

        for(int value : graph.get(idx)){//현재 idx와 연결된 다른 값
            if(visited[value]) continue;
            DFS(value);
        }
    }
}
