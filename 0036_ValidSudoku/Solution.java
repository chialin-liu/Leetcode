class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        for(int i = 0; i < 9; i++){
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if(board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) return false;
            }
        }
        return true;
    }
}
