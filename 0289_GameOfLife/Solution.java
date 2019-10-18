class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int live = getLive(board, i, j);
                if(board[i][j] == 1){
                    if(live == 2 || live == 3){
                        board[i][j] += 2;
                    }
                }
                else{
                    if(live == 3){
                        board[i][j] += 2;
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = board[i][j] / 2;
            }
        }
    }
    public int getLive(int [][] board, int a, int b){
        int count = 0;
        for(int i = Math.max(0, a - 1); i <= Math.min(a + 1, board.length - 1); i++){
            for(int j = Math.max(0, b - 1); j <= Math.min(b + 1, board[0].length - 1); j++){
                if(i == a && j == b) continue;
                if((board[i][j] & 1) == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
