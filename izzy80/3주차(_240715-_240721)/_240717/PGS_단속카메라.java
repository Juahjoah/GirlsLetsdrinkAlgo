import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
         int answer = 0;
	        
	        // 1. 진출 시점 기준으로 오름차순 정렬(이차원배열에서)
	        Arrays.sort(routes, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] == o2[1]) {
						return o1[0]-o2[0];
					}
					return o1[1] - o2[1];
				}
			});
	      
	     
	        // 2. 카메라가 설치된 것이 진입 시점보다 앞에 있으면 새로운 카메라를 설치! => 반복
	        int current = -30001;
	        
	        for(int i=0; i<routes.length; i++) {
	        	if(current < routes[i][0] ) {
	        		//현재 카메라의 위치가 진입 지점보다 작다면
	        		current = routes[i][1]; //새로운 카메라를 진출 지점에 설치한다. 
	        		answer++;
	        	}
	        }
	        return answer;
	    }
}