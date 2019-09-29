public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    public boolean [][] isPalin(String s){
        int n = s.length();
        boolean [][]res = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = false;
            }
        }
        for(int mid = 0; mid < n; mid++){
            int i = mid;
            int j = mid;
            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
                
                    res[i][j] = true;
                    
                
                i--;
                j++;
            }
            
            i = mid - 1;
            j = mid;
            while(i >= 0 && j < n && s.charAt(i) == s.charAt(j)){
                
                    res[i][j] = true;
                    
                
                i--;
                j++;
            }
            
        }
        return res;
    }
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() == 0) return 0;
        int [] f = new int [s.length() + 1];
        int n = s.length();
        boolean [][]palin = isPalin(s);
        f[0] = 0;
        for(int i = 1; i <= n ; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if(palin[j][i - 1]){
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n] - 1;
    }
}
