public class Solution {
    /**
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        // write your code here
        int []f = new int [n + 1];
        f[0] = 0;
        for(int i = 1; i <= n; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                f[i] = Math.min(f[i], f[i - j * j] + 1); 
            }
        }
        return f[n];
    }
}
