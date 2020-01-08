class TicTacToe {

    /** Initialize your data structure here. */
    int [][]board;
    int []row ;
    int []col;
    int diag;
    int antiDiag;
    int len;
    public TicTacToe(int n) {
        len = n;
        board = new int[n][n];
        row = new int[n];
        col = new int[n];
        diag = 0;
        antiDiag = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int r, int c, int player) {
        board[r][c] = (player == 1)? 1: -1;
        row[r] += board[r][c];
        col[c] += board[r][c];
        if(r == c){
            diag += board[r][c];
        }
        if(r + c == len - 1){
            antiDiag += board[r][c];
        }
        int win = 0;
        boolean xwin = false;
        boolean owin = false;
        for(int i = 0; i < len; i++){
            if(row[i] == len){
                xwin = true;
            }
            if(col[i] == len){
                xwin = true;
            }
            if(row[i] == -len){
                owin = true;
            }
            if(col[i] == -len){
                owin = true;
            }
        }
        xwin = xwin || (diag == len) || (antiDiag == len);
        owin = owin || (diag == -len) || (antiDiag == -len);   
        return xwin == false && owin == false? 0:(xwin == true? 1: 2);
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
