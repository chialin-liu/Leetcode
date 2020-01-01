class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int []dp = new int [nums.length];
        dp[0] = nums[0];
        int len = 0;
        int start = 0;
        int end = 0;
        for(int i = 1; i < nums.length; i++){
            start = 0;
            end = len;
            int index = bs(nums[i], dp, start, end);
            if(index == -1){
                len++;
                dp[len] = nums[i];
            }
            else{
                dp[index] = nums[i];
            }
        }
        return len + 1;
    }
    public int bs(int target, int []dp, int start, int end){
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(target <= dp[mid]){
                end = mid;
            }
            else{
                start = mid;
            }
            
        }
            if(dp[start] >= target){
                return start;
            }
            else if(dp[end] >= target){
                return end;
            }
            else{
                return -1;
            }
    }
}
