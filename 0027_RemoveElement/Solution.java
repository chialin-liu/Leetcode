class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != val){
                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp;
                start++;
            }
        }
        return start;
        
    }
    
}
