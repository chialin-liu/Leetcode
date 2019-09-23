class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            while(left <= i && sum >= s){
                res = Math.min(res, i - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }
        return (res == Integer.MAX_VALUE)? 0: res;        
    }
}
