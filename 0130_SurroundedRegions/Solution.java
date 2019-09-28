class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length - 1;
        int n = board[0].length - 1;
        for(int i = 0; i <= m; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if(board[i][n] == 'O'){
                dfs(board, i, n);
            }
        }
        for(int i = 0; i <= n; i++){
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
            if(board[m][i] == 'O'){
                dfs(board, m, i);
            }
        }
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char [][]board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')return ;
        board[i][j] = '1';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i , j + 1);
        dfs(board, i , j - 1);
        
    }
}
