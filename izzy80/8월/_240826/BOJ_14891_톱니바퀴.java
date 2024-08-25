package BOJ;
import java.util.*;
import java.io.*;
public class BOJ_14891_톱니바퀴 {
    static int WHEEL_CNT = 4; //톱니바퀴의 갯수
    static int WHEEL_SIZE = 8; //톱니바퀴의 톱니 개수
    static ArrayList<Integer>[] wheel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheel= new ArrayList[WHEEL_CNT+1];
        for(int i=1; i<=WHEEL_CNT; i++){
            wheel[i] = new ArrayList<>();
            String tmp = br.readLine();
            for(int j=0; j < WHEEL_SIZE; j++){
                wheel[i].add(tmp.charAt(j)-'0');
            }
        }

        //출력
//        for(int i=1; i<=WHEEL_CNT; i++){
//            for(int j=0; j < 8; j++){
//                System.out.print(wheel[i].get(j)+" ");
//            }
//            System.out.println();
//        }

        int N = Integer.parseInt(br.readLine()); //회전 횟수
        StringTokenizer st;
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int wheel_number = Integer.parseInt(st.nextToken()); // 톱니바퀴의 번호
            int dir = Integer.parseInt(st.nextToken()); //방향 //1 : 시계, -1 : 반시계


            int[] isTurn = new int[WHEEL_CNT+1]; //1 : 시계, 0 : 없음, -1 : 반시계
            isTurn[wheel_number] = dir; //내거 처리

            boolean turn = false;
            switch(wheel_number){
                case 1:
                    for(int j = wheel_number; j <= WHEEL_CNT-1; j++){
                        if(wheel[j].get(2) != wheel[j+1].get(6)){//같지않으면
                            isTurn[j+1] = isTurn[j]*(-1); //반대방향
                        }
                        else{ //같으면 변화 없음
                            break;
                        }
                    }
                    break;
                case 2:
                    if(wheel[1].get(2) != wheel[2].get(6)){
                        isTurn[1] = isTurn[2]*(-1);
                    }
                    if(wheel[2].get(2) != wheel[3].get(6)){
                        isTurn[3] = isTurn[2]*(-1);
                        turn = true;
                    }
                    if(turn){//3,4번도 체크
                        if(wheel[3].get(2) != wheel[4].get(6)){
                            isTurn[4] = isTurn[3]*(-1);
                        }
                    }
                    break;
                case 3:
                    turn = false;
                    if(wheel[2].get(2) != wheel[3].get(6)){
                        isTurn[2] = isTurn[3]*(-1);
                        turn = true;
                    }
                    if(turn){//2번 움직임 -> 1번도 움직임?
                        if(wheel[1].get(2) != wheel[2].get(6)){
                            isTurn[1] = isTurn[2]*(-1);
                        }
                    }
                    if(wheel[3].get(2) != wheel[4].get(6)){
                        isTurn[4] = isTurn[3]*(-1);
                    }

                    break;
                case 4:
                    for(int j = wheel_number; j > 1; j--){
                        if(wheel[j].get(6) != wheel[j-1].get(2)){//같지않으면
                            isTurn[j-1] = isTurn[j]*(-1);
                        }
                        else{ //같으면 변화 없음
                            break;
                        }
                    }
                    break;
            }
            //isTurn에 저장된 것 가지고 wheel 회전
            for(int j=1; j <=WHEEL_CNT; j++){
                Turn(j,isTurn[j]);
            }
//            System.out.println(Arrays.toString(isTurn));
        }

        //계산
        int ans = 0;
        if(wheel[1].get(0) == 1) ans+=1;
        if(wheel[2].get(0) == 1) ans+=2;
        if(wheel[3].get(0) == 1) ans+=4;
        if(wheel[4].get(0) == 1) ans+=8;

        //출력
        System.out.println(ans);
    }

    static public void Turn(int wheel_number, int dir){
        if(dir == 1){//1이면 시계방향
            int end = wheel[wheel_number].get(WHEEL_SIZE-1); //맨 마지막 가져오고
            wheel[wheel_number].remove(WHEEL_SIZE-1); //맨 마지막 삭제하고
            //맨 앞에 집어넣는다.
            wheel[wheel_number].add(0,end);
        }
        else if(dir == -1){//-1이면 반시계 방향
            int start = wheel[wheel_number].get(0); //맨 앞 가져오고
            wheel[wheel_number].remove(0); //맨 앞 삭제하고
            //맨 뒤에 집어넣는다.
            wheel[wheel_number].add(start);
        }
        //0은 변화 없음
    }
}
