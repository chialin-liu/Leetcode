class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0 ) return ;
        int left = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                nums[left] = nums[i];
                left++;
            }
        }
        for(int i = left; i < n; i++){
            nums[i] = 0;
        }
    }
}
