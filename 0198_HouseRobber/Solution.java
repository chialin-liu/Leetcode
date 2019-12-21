class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length <= 2){
            int temp = 0;
            for(int i = 0; i < nums.length; i++){
                temp = Math.max(temp, nums[i]);
            }
            return temp;
        }
        int odd = 0;
        int even = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                even = Math.max(even + nums[i], odd);
            }
            else{
                odd = Math.max(odd + nums[i], even);
            }
        }
        return Math.max(even, odd);
    }
}
