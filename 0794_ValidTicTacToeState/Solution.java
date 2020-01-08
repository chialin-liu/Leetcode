class Solution {
    public boolean validTicTacToe(String[] board) {
        int []row = new int[3];
        int []col = new int[3];
        int diag = 0;
        int antiDiag = 0;
        int turns = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i].charAt(j) == 'O'){
                    turns--;
                    row[i]--;
                    col[j]--;
                    if(i == j){
                        diag--;
                    }
                    if(i + j == 2){
                        antiDiag--;
                    }
                }
                else if(board[i].charAt(j) == 'X'){
                    turns++;
                    row[i]++;
                    col[j]++;
                    if(i == j){
                        diag++;
                    }
                    if(i + j == 2){
                        antiDiag++;
                    }
                }
            }
        }
        boolean xwin = false;
        boolean owin = false;
        xwin = (row[0] == 3) || (row[1] == 3) || (row[2] == 3) || (col[0] == 3) || (col[1] == 3) || (col[2] == 3) || (diag == 3) || (antiDiag == 3);
        owin = (row[0] == -3) || (row[1] == -3) || (row[2] == -3) || (col[0] == -3) || (col[1] == -3) || (col[2] == -3) || (diag == -3) || (antiDiag == -3);
        
        if((xwin == true && turns == 0) || (owin == true && turns == 1)){
            return false;
        }
        return (turns == 0 || turns == 1) && (!xwin || !owin);
    }
}
