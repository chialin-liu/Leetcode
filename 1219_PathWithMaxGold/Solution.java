class Solution {
    public int getMaximumGold(int[][] grid) {
        boolean [][]visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) continue;
                visited = new boolean[grid.length][grid[0].length];
                int amount = dfs(i, j, grid, visited, 0);
                max = Math.max(max, amount);
            }
        }
        return max;
    }
    public int dfs(int row, int col, int [][]grid, boolean [][]visited, int cur){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0){
            return cur;
        }
        cur = cur + grid[row][col];
        visited[row][col] = true;
        int down = dfs(row + 1, col, grid, visited, cur);
        int up = dfs(row - 1, col, grid, visited, cur);
        int right = dfs(row, col + 1, grid, visited, cur);
        int left = dfs(row, col - 1, grid, visited, cur);
        visited[row][col] = false;
        return Math.max(up, Math.max(down, Math.max(right, left)));
    }
}
