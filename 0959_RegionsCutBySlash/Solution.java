class Solution {
    public int regionsBySlashes(String[] grid) {
        boolean [][]map = new boolean[grid.length * 3][grid.length * 3];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length(); j++){
                if(grid[i].charAt(j) == '\\'){
                    map[3 * i    ][3 * j    ] = true;
                    map[3 * i + 1][3 * j + 1] = true;
                    map[3 * i + 2][3 * j + 2] = true;
                   }
                else if(grid[i].charAt(j) == '/'){
                    map[3 * i + 2][3 * j    ] = true;
                    map[3 * i + 1][3 * j + 1] = true;
                    map[3 * i    ][3 * j + 2] = true;                    
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if(map[i][j] == false){
                    ans++;
                    dfs(map, i, j);
                }
            }
        }
        return ans;
    }
    public void dfs(boolean [][]map, int row, int col){
        if(row < 0 || row >= map.length || col < 0 || col >= map[0].length || map[row][col] == true){
            return;
        }
        map[row][col] = true;
        dfs(map, row + 1, col);
        dfs(map, row - 1, col);
        dfs(map, row    , col + 1);
        dfs(map, row    , col - 1);
    }
}
