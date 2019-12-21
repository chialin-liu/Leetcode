class Solution {
    public int deleteAndEarn(int[] nums) {
        int []dp = new int[10001];
        int take = 0;
        int skip = 0;
        for(int i = 0; i < nums.length; i++){
            dp[nums[i]] += nums[i];
        }
        int takei;
        int skipi;
        for(int i = 0; i < 10001; i++){
            takei = skip + dp[i];
            skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }
        return Math.max(skip, take);
    }
}
