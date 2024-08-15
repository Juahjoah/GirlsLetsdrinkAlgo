import java.util.*;

class Solution {
    static int[] mover = {0,1,1};
    static int[] movec = {1,0,1};
    static int M,N;
    static char[][] map;
    public int solution(int m, int n, String[] board) {
         int answer = 0;
            M = m;
            N = n;
            map = new char[M][N];
            for(int i=0; i<M; i++){
                String str = board[i];
                for(int j=0; j< N; j++){
                    map[i][j] = str.charAt(j);
                }
            }

            while(true){
                boolean[][] checked = new boolean[M][N];
                boolean ispossible = broken(checked);
                if(!ispossible) break;
                //깰 수 없으면 멈추고
                //깰 수 있으면 깨고 map 갱신
                update(checked);
            }


            for(int i=0; i < M; i++){
                for(int j=0; j < N; j++){
                    if(map[i][j] == '0') answer++;
                }
            }
            return answer;
    }
    public void update(boolean[][] checked){
            for(int c = 0 ; c < N; c++) {
                Queue<Character> q = new LinkedList<>();
                for (int r = M-1; r >=0; r--) {
                    if(!checked[r][c]) q.add(map[r][c]);
                }
                for (int r = M-1; r >=0; r--) {
                    if(!q.isEmpty()){
                        map[r][c] = q.poll();
                    }
                    else{
                        map[r][c] = '0';
                    }
                }
            }

        }

        public boolean  broken(boolean[][] checked){
             boolean ispossible = false;

            for(int i=0; i<M-1; i++){
                for(int j=0; j< N-1; j++){
                    char c = map[i][j];
                    if(c == '0') continue;

                    int cnt = 1;
                    for(int k=0; k < 3; k++){
                        char target = map[i+mover[k]][j+movec[k]];
                        if(c == target) {
                            cnt++;
                        }
                        else{
                            break;
                        }
                    }
                    if(cnt == 4){
                        checked[i][j] = true;
                        ispossible = true;
                        for(int k=0; k < 3; k++) {
                            checked[i + mover[k]][j + movec[k]] = true;
                        }
                    }
                }
            }

            return ispossible;
        }
}