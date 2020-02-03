class Solution {
    public int islandPerimeter(int[][] grid) {
        int total = 0;
        int duplicate = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    total++;
                    if(i >= 1 && grid[i - 1][j] == 1) duplicate++;
                    if(j >= 1 && grid[i][j - 1] == 1) duplicate++; 
                }
            }
        }
        
        return total * 4 - duplicate * 2;
    }
}
