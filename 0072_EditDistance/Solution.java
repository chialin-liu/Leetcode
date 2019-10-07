class Solution {
    public int minDistance(String word1, String word2) {
        char [] w1 = word1.toCharArray();
        char [] w2 = word2.toCharArray();
        int m = w1.length;
        int n = w2.length;
        int [][] dp = new int [m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0){
                    dp[i][j] = j;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = i;
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                if(w1[i - 1] == w2[j - 1]){
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
