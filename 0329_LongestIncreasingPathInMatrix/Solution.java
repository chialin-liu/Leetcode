class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int max = 0;
        int [][]cache = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = helper(matrix, i, j, m, n, Integer.MIN_VALUE, cache);
                res = Math.max(res, max);
            }
        }
        return res;
    }
    public int helper(int [][]matrix, int row, int col, int m, int n, int preValue, int [][]cache){
        if(row < 0 || col < 0 || row >= m || col >= n || matrix[row][col] <= preValue ) return 0;
        if(cache[row][col] != 0) return cache[row][col];
        int pre = matrix[row][col];
        int a = helper(matrix, row + 1, col, m, n, pre, cache) + 1;
        int b = helper(matrix, row - 1, col, m, n, pre, cache) + 1;
        int c = helper(matrix, row, col + 1, m, n, pre, cache) + 1;
        int d = helper(matrix, row, col - 1, m, n, pre, cache) + 1;
        int res = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[row][col] = res;
        return res;
        
    }
}
