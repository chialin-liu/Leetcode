class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        char []A = s1.toCharArray();
        char []B = s2.toCharArray();
        char []C = s3.toCharArray();
        if(C.length != A.length + B.length) return false;
        boolean [][] dp = new boolean[A.length + 1][B.length + 1];
        int m = A.length;
        int n = B.length;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                if(i > 0 && C[i + j - 1] == A[i - 1] && dp[i - 1][j]){
                    dp[i][j] = true;
                }
                if(j > 0 && C[i + j - 1] == B[j - 1] && dp[i][j - 1]){
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
}
