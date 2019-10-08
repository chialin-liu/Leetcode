class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0) return 0;
        int len = strs.length;
        int [] one = new int [len];
        int [] zero = new int [len];
        
        for(int i = 0; i < len; i++){
            char [] s = strs[i].toCharArray();
            for(int j = 0; j < s.length; j++){
                if(s[j] == '0') zero[i]++;
                else one[i]++;
            }
        }
        int [][][] dp = new int [len + 1][m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                dp[0][i][j] = 0;
            }
        }
        for(int i = 1; i <= len; i++){
            for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(j >= zero[i - 1] && k >= one[i - 1]){
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zero[i - 1]][k - one[i - 1]] + 1);
                    }
                }
            }
        }
        int res = 0;
        for(int j = 0; j <= m; j++){
                for(int k = 0; k <= n; k++){
                    res = Math.max(res, dp[len][j][k]);
                }
        }
        return res;
    }
}
