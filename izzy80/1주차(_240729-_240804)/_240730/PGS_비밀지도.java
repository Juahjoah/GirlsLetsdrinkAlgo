class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];


            for(int i=0; i < n; i++){
                String a = Integer.toBinaryString(arr1[i]|arr2[i]);
                if(a.length() < n){
                    String zero = "";
                    for(int j = 0; j < n-a.length(); j++){
                        zero+="0";
                    }
                    a = zero+a;
                }
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(a.charAt(j) == '1') sb.append("#");
                    else sb.append(" ");
                }
                answer[i] = sb.toString();
            }


            return answer;
    }
}