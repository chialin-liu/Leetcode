class Solution {
    public boolean isMatch(String s, String p) {
        char [] ss = s.toCharArray();
        char [] pp = p.toCharArray();
        
        int m = ss.length;
        int n = pp.length;
        
        boolean [][]dp = new boolean[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = false;
                    continue;
                }
                dp[i][j] = false;
                if(pp[j - 1] != '*'){
                  if(i > 0 && (pp[j - 1] == ss[i - 1] || pp[j - 1] == '.')){
                    dp[i][j] = dp[i - 1][j - 1];
                    }  
                }
                else{
                    if(j > 1){
                        dp[i][j] = dp[i][j - 2];
                    }
                    if(i > 0 && j > 1 && (pp[j - 2] == '.' || pp[j - 2] == ss[i - 1])){
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
