class Solution {
    public int findNumberOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        int []cnt = new int[nums.length];
        
        int res = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] == dp[j] + 1){
                        cnt[i] += cnt[j];
                    }
                    else if(dp[i] < dp[j] + 1){
                        cnt[i] = cnt[j];
                        dp[i] = dp[j] + 1;
                    }
                  
                }
            }
            if(max == dp[i]) res += cnt[i];
            else if(max < dp[i]){
                max = dp[i];
                res = cnt[i];
            }
        }
        
        return res;
    }
}
