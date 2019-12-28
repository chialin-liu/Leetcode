class Solution {
    int res;
    public int uniquePathsIII(int[][] grid) {
        res = 0;
        int empty = 0;
        int sx = 0;
        int sy = 0;
        int ex = 0;
        int ey = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    empty++;
                }
                else if(grid[i][j] == 1){
                    sx = j;
                    sy = i;
                }
                else if(grid[i][j] == 2){
                    ex = j;
                    ey = i;
                }
            }
        }
        dfs(grid, sx, sy, ex, ey, empty, 0);
        return res;
    }
    public void dfs(int [][]grid, int sx, int sy, int ex, int ey, int empty, int curEmpty){
        if(sx >= grid[0].length || sx < 0 || sy < 0 || sy >= grid.length || grid[sy][sx] == -1 || grid[sy][sx] == -2){
            return;
        }
        if(grid[sy][sx] == 0){
            curEmpty++;
        }
        if(sx == ex && sy == ey && curEmpty == empty){
            res++;
            return;
        }
        int temp = grid[sy][sx];
        grid[sy][sx] = -2;
        dfs(grid, sx + 1, sy    , ex, ey, empty, curEmpty);
        dfs(grid, sx - 1, sy    , ex, ey, empty, curEmpty);
        dfs(grid, sx    , sy + 1, ex, ey, empty, curEmpty);
        dfs(grid, sx    , sy - 1, ex, ey, empty, curEmpty);
        grid[sy][sx] = temp;
        
    }
}
