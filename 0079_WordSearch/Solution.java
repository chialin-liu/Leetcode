class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helper(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char [][] board, String word, int i, int j, int start){
        if(start == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] == word.charAt(start)){
            start++;
            Character tmp = board[i][j];
            board[i][j] = '#';
            boolean res = helper(board, word, i + 1, j, start) || 
                          helper(board, word, i - 1, j, start) ||
                          helper(board, word, i,     j + 1, start) ||
                          helper(board, word, i,     j - 1, start);
            board[i][j] = tmp;
            return res;
        }
        return false;
    }
}
