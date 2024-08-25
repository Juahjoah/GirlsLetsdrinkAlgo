/*
- 두 사람 사이에 더 많은 선물을 준 사람이 선물을 받음
- 선물 기록이 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 받음 
    - 선물 지수 : 이번달까지 자신이 친구들에게 준 선물의 수 - 받은 선물의 수 
- 선물지수도 같다면 다음 달에 선물을 주고받지 않음

선물을 가장 많이 받을 친구가 받을 선물의 수는?

*/
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length; 
        HashMap<String, Integer> hm = new HashMap<>(); //이름, index 
        int[] idx = new int[n]; //선물지수 
        int[][] giftCnt = new int[n][n]; //graph 구성 
       
        for(int i=0; i < n; i++){
            hm.put(friends[i],i);
        }
        
        for(int i=0; i < gifts.length; i++){
            String[] str = gifts[i].split(" ");
            int r = hm.get(str[0]); //줌
            int c = hm.get(str[1]); //받음 
            idx[r]++; //주면 더해주기
            idx[c]--; //받으면 빼주기 
            
            giftCnt[r][c] += 1; 
        }
             
        int max = 0; 
        for(int i=0; i < n; i++){
            int sum = 0; 
            for(int j=0; j < n; j++){
                if(i == j) continue; 
                if(giftCnt[i][j] == giftCnt[j][i]){
                    if(idx[i] > idx[j]) sum++; 
                }
                else if(giftCnt[i][j] > giftCnt[j][i]){
                    sum++; 
                }
            }
            
            if(max < sum) max = sum; 
        }
        return max;
    }
}