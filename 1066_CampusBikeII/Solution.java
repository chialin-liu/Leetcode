class Solution {
    int min;
    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean []visited = new boolean[bikes.length];
        min = Integer.MAX_VALUE;
        dfs(visited, workers, 0, bikes, 0);
        return min;
    }
    public void dfs(boolean []visited, int [][]workers, int index, int [][]bikes, int dist){
        
        if(index == workers.length){
            min = Math.min(min, dist);
            return;
        }
        if(dist > min){
            return;
        }
        for(int j = 0; j < bikes.length; j++){
            if(visited[j]) continue;
            visited[j] = true;
            int d = Math.abs(workers[index][0] - bikes[j][0]) + Math.abs(workers[index][1] - bikes[j][1]);
            dfs(visited, workers, index + 1, bikes, dist + d);
            visited[j] = false;
        }
    }
}
