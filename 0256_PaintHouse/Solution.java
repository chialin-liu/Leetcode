public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        int m = costs.length;
        int [][]f = new int [m + 1][3];
        f[0][0] = 0;
        f[0][1] = 0;
        f[0][2] = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 0; j < 3; j++){
                f[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++){
                    if(j == k) continue;
                    f[i][j] = Math.min(f[i][j], f[i - 1][k] + costs[i -1][j]);
                }
            }
        }
        return Math.min(f[m][0], Math.min(f[m][1], f[m][2]));
    }
}
