/*
한 번에 한 명의 유저를 신고할 수 있다. 
- 신고 횟수 제한 X. 단 동일한 유저에 대한 신고는 1번으로 처리 
k번 이상 신고된 유저는 게시판 정지. 해당 유저를 신고한 모든 유저에게 메일 발송 
*/
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        HashMap<String, Integer> nameIdx = new HashMap<>(); 
        for(int i=0; i < n; i++){
            nameIdx.put(id_list[i],i);
        }
        
        int[][] graph = new int[n][n]; 
        int[] reportCnt = new int[n]; //신고 받은 횟수 
        for(int i=0; i < report.length; i++){
            String[] str = report[i].split(" ");
            int r = nameIdx.get(str[0]);
            int c = nameIdx.get(str[1]);
            
            if(graph[r][c] == 0){//중복이면 신고 처리 안 됨. 
                graph[r][c]++; 
                
                reportCnt[c]++;
            }
        }
        //reportCnt 돌면서 k이상인거 
        for(int i =0; i < n; i++){
            if(reportCnt[i] >= k){
                for(int j=0; j < n; j++){
                    if(graph[j][i] > 0) answer[j]++;
                }    
                
            }
        }
        return answer;
    }
}