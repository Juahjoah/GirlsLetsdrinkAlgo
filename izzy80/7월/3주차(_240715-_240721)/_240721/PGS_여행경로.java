import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean visited[];
    
    public String[] solution(String[][] tickets) {
         String[] answer = {};

            visited = new boolean[tickets.length];

            DFS(0, "ICN" , "ICN" , tickets);

            Collections.sort(list);

            answer = list.get(0).split(" ");

            return answer;
    }
    private void DFS(int depth, String now, String path, String[][] tickets) {
            if(depth == tickets.length){
                list.add(path);
                return;
            }

            for(int i=0; i< visited.length ; i++){
                if(!visited[i] && now.equals(tickets[i][0])){
                    //방문하지 않았고, 현재 티켓의 출발지와 같다면
                    visited[i] = true; //방문처리
                    DFS(depth+1, tickets[i][1], path+" "+tickets[i][1], tickets);
                    visited[i] = false; //방문처리 취소
                }
            }
        }
}