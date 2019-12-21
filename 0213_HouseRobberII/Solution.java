class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robByPosition(nums, 0), robByPosition(nums, 1));
    }
    public int robByPosition(int []nums, int start){
        int []dp = new int [nums.length - 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start + 1], nums[start]);
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
