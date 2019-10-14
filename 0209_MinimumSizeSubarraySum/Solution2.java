class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = -1;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(left < nums.length){
            if(sum < s && right < nums.length - 1){
                right++;
                sum = sum + nums[right];
                
            }
            else{
                sum = sum - nums[left];
                left++;
            }
            if(sum >= s){
                res = Math.min(res, right - left + 1);
            }
        }
        if(res == Integer.MAX_VALUE){
            return 0;
        }
        else{
            return res;
        }
    }
}
