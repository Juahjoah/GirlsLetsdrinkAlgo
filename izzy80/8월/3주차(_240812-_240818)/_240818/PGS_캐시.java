import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        ArrayList<String> path = new ArrayList<>(); 
        
        if(cacheSize == 0){
            return cities.length * 5; 
        }
        
        for(int i=0; i < cities.length; i++){
            String ct = cities[i].toLowerCase();
            if(path.contains(ct)) {
                //존재한다면 
                answer+=1; 
                path.remove(ct);
            }
            else{//없다면 
                if(path.size() == cacheSize) path.remove(0);
                answer+=5; 
            }
             path.add(ct);
        }
        return answer;
    }
}