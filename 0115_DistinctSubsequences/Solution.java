class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        int n = s.length();
        int m = t.length();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int [][] dp = new int [n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(ss[i - 1] == tt[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                dp[i][j] += dp[i - 1][j];
            }
        }
        return dp[n][m];
    }
}
