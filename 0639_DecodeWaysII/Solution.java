class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        char [] ss = s.toCharArray();
        long [] dp = new long [n + 1];
        long MOD = 1000000007;
        for(int i = 0; i <= n; i++){
            if(i == 0){
                dp[0] = 1;
                continue;
            }
           
            dp[i] += dp[i - 1] * cnt1(ss[i - 1]);
            
            if(i >= 2){
                dp[i] += dp[i - 2] * cnt2(ss[i - 2], ss[i - 1]);
            }
            dp[i] = dp[i] % MOD;
            
        }
        return (int)dp[n];
    }
    private int cnt1(char s){
        if(s == '0'){
            return 0;
        }
        else if(s != '*'){
            return 1;
        }
        else{
            return 9;
        }
    }
    private int cnt2(char c2, char c1){
        if(c2 == '0') return 0;
        else if(c2 == '1'){
            if(c1 == '*'){
                return 9;
            }
            else{
                return 1;
            }
        }
        else if(c2 == '2'){
            if(c1 == '*'){
                return 6;
            }
            else if(c1 <= '6'){
                return 1;
            }
            else{
                return 0;
            }
        }
        else if(c2 >= '3' && c2 <= '9') return 0;
        else if(c2 == '*'){
            if(c1 >= '0' && c1 <= '6'){
                return 2;
            }
            else if(c1 >= '7' && c1 <= '9'){
                return 1;
            }
            else{
                return 15;
            }
        }
        return 15;
    }
}
