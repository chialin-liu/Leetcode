class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[count - 2]){
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}
