class Solution {
    int count;
    public int countArrangement(int N) {
        count = 0;
        int pos = 1;
        boolean []visited = new boolean[N + 1];
        dfs(N, 1, pos, visited);
        return count;
    }
    public void dfs(int N, int num, int pos, boolean []visited){
        if(pos > N){
            count++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!visited[i] && (i % pos == 0 || pos % i == 0)){
                visited[i] = true;
                dfs(N, i, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
