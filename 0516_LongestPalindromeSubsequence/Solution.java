public class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        char []ss = s.toCharArray();
        if(ss.length <= 1){
            return ss.length;
        }
        int n = s.length();
        
        int [][] f = new int [n][n];
        
        for(int i = 0; i < n; i++){
            f[i][i] = 1;
        }
        
        for(int i = 0; i < n - 1; i++){
            f[i][i + 1] = (ss[i] == ss[i + 1])? 2: 1;
        }
        
        for(int len = 3; len <= n; len ++){
            for(int i = 0; i <= n - len; i++){
                int j = i + len - 1;
                f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                if(ss[i] == ss[j]){
                    f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        return f[0][n - 1];
    }
}
