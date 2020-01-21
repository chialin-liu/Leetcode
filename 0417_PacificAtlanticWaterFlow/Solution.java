class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>(); 
        int row = matrix.length;
        int col = matrix[0].length;
        
        boolean [][]pacific = new boolean[row][col];
        boolean [][]atlantic = new boolean[row][col];
        for(int i = 0; i < row; i++){
            dfs(matrix, pacific, i, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, i, col - 1, Integer.MIN_VALUE);
        }
        for(int i = 0; i < col; i++){
            dfs(matrix, pacific, 0, i, Integer.MIN_VALUE);
            dfs(matrix, atlantic, row - 1, i, Integer.MIN_VALUE);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
    public void dfs(int [][]matrix, boolean [][]visited, int row, int col, int pre){
        if(row >= matrix.length || col >= matrix[0].length || row < 0 || col < 0 || matrix[row][col] < pre || visited[row][col] == true) return;
        visited[row][col] = true;
        dfs(matrix, visited, row + 1, col, matrix[row][col]);
        dfs(matrix, visited, row - 1, col, matrix[row][col]);
        dfs(matrix, visited, row, col + 1, matrix[row][col]);
        dfs(matrix, visited, row, col - 1, matrix[row][col]);
    }
}
