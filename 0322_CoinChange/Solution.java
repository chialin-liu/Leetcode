public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // write your code here
        int []f = new int [amount + 1];
        f[0] = 0;
        for(int i = 1; i <= amount; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j] && (f[i - coins[j]] != Integer.MAX_VALUE) ){
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        if(f[amount] == Integer.MAX_VALUE) return -1;
        return f[amount];
    }
}
