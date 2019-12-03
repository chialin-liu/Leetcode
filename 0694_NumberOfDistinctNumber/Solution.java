class Solution {
    int [][]pairs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> set = new HashSet<>();
        int res = 0;
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 0, 0, sb);
                    if(!set.contains(sb.toString())){
                        res++;
                        set.add(sb.toString());
                    }
                }
            }
        }
        return res;
    }
    public void dfs(int [][]grid, int i, int j, int posX, int posY, StringBuilder sb){
        grid[i][j] = 0;
        sb.append(posX);
        sb.append("-");
        sb.append(posY);
        for(int []pair: pairs){
            int x = i + pair[0];
            int y = j + pair[1];
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) continue;
            dfs(grid, x, y, posX + pair[0], posY + pair[1], sb);
        }
    }
}
