public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int res = 0;
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
        
    }
}
