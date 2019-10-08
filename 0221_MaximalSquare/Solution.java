class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int [][]dp = new int [m][n];
        for(int i =  0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = 1;
                if(i >= 1 && j >= 1){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                res = Math.max(res, dp[i][j] * dp[i][j]);
            }
        }    
        return res;

    }
}
