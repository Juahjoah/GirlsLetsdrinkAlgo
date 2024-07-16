class Solution {
    static boolean[] visited; 
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = Integer.MIN_VALUE;
        visited = new boolean[dungeons.length];
        dfs(k, 0,dungeons);
        return answer;
    }
    
    public void dfs(int blood, int depth, int[][] dungeons){
        for(int i=0; i < dungeons.length; i++){
            if(visited[i]) continue;
            if(dungeons[i][0] > blood) continue;
            visited[i] = true; 
            dfs(blood-dungeons[i][1],depth+1, dungeons);
            visited[i] = false; 
        }
        answer = Math.max(answer, depth);
    }
}