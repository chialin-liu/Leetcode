public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] A) {
        // write your code here
        if(A == null || A.length == 0 || A[0].length == 0){
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int [][]f = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++ ){
                if(A[i][j] == 1){
                    f[i][j]= 0;
                    continue;
                }
                if(i == 0 && j == 0){
                    f[i][j] = 1;
                    continue;
                }
                if(i > 0){
                    f[i][j] += f[i - 1][j];
                }
                if(j > 0){
                    f[i][j] += f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}
