import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
            ArrayList<String> arr = new ArrayList<>();
        
            if(cacheSize == 0) return cities.length * 5;

            for(int i=0; i < cities.length; i++){
                String str = cities[i].toLowerCase();

                if(arr.contains(str)){ //만약 있다면
                    arr.remove(str); //해당 도시 지우고
                    arr.add(str); //맨 뒤에 추가
                    answer+=1;
                }

                else{ //없다면
                    if(arr.size()==cacheSize){ //이미 캐시 꽉차있으면
                        arr.remove(0); //맨 앞 도시 지우고
                    }
                    //캐시가 다 안찼으면
                    arr.add(str); //맨 뒤에 추가
                    answer+=5;
                }
            }
            return answer;
    }
}