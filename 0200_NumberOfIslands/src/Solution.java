public class Solution {
  public int numIslands(char[][] grid) {
    if(grid == null | grid.length == 0){
      return 0;
    }
    int row = grid.length;
    int col = grid[0].length;
    if((row == 0 & col == 0)){
      return 0;
    }
    int numOfIslands = 0;
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        if(grid[i][j]=='1'){
          numOfIslands++;
          dfs(grid,row,col,i,j);
        }
      }
    }
    return numOfIslands;
  }
  public void dfs(char[][]grid, int row, int col, int i, int j){
    if(i >= row | j >= col | i < 0 | j < 0){
      return ;
    }
    if(grid[i][j] == '0'){
      return;
    }
    grid[i][j]='0';
    dfs(grid,row,col,i-1,j);
    dfs(grid,row,col,i+1,j);
    dfs(grid,row,col,i,j-1);
    dfs(grid,row,col,i,j+1);
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    char [][]grid=new char[4][5];
    grid[0][0]='1';
    grid[0][1]='1';
    grid[0][2]='0';
    grid[0][3]='0';
    grid[0][4]='0';

    grid[1][0]='1';
    grid[1][1]='1';
    grid[1][2]='0';
    grid[1][3]='0';
    grid[1][4]='0';

    grid[2][0]='0';
    grid[2][1]='0';
    grid[2][2]='1';
    grid[2][3]='0';
    grid[2][4]='0';

    grid[3][0]='0';
    grid[3][1]='0';
    grid[3][2]='0';
    grid[3][3]='1';
    grid[3][4]='1';
    char [][]xx=new char[4][5];
    System.out.println(sol.numIslands(grid));
  }
}
