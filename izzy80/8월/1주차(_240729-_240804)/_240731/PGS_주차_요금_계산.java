import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
            HashMap<String, String> hm = new HashMap<>();
            TreeMap<Integer,Integer> hm1 = new TreeMap<>(); //차량번호, 시간
            for(int i=0; i < records.length; i++){
                String[] tmp = records[i].split(" ");
                if(tmp[2].equals("IN")){
                    hm.put(tmp[1], tmp[0]);
                }
                else{//출차
                    String[] intime = hm.get(tmp[1]).split(":");
                    hm.remove(tmp[1]);
                    String[] outtime = tmp[0].split(":");

                    hm1.put(Integer.parseInt(tmp[1]),hm1.getOrDefault(Integer.parseInt(tmp[1]),0)+solve(intime, outtime, fees));
                }
            }
            //출차 안 한 차
            if(!hm.isEmpty()){
              for(String id : hm.keySet()){
                  String[] intime = hm.get(id).split(":");
                  String[] outtime = "23:59".split(":");

                  hm1.put(Integer.parseInt(id),hm1.getOrDefault(Integer.parseInt(id),0)+solve(intime, outtime, fees));
              }
            }
            int[] answer = new int[hm1.size()];
            int idx = 0;
            for(Integer id : hm1.keySet()){
//                System.out.println("id = "+id + ",hour = "+hm1.get(id));
                int price = fees[1];
                if(hm1.get(id) >= fees[0]){
                    price = fees[1] + (int)(Math.ceil(((double)hm1.get(id) - fees[0])/fees[2])*fees[3]);
                }
                answer[idx++] = price;
            }

            return answer;
        }
        public int solve(String[] intime,String[] outtime, int[] fees){
            int inH = Integer.parseInt(intime[0]);
            int inM = Integer.parseInt(intime[1]);
            int outH = Integer.parseInt(outtime[0]);
            int outM = Integer.parseInt(outtime[1]);

            int H = outH-inH;
            int M = outM-inM;
            if(M < 0){
                M += 60;
                H--;
            }
            int total = H*60+M;
            return total;
        }
}