class Solution {
    int [] nums;
    Random rnd;
    // int count;
    public Solution(int[] nums) {
        this.rnd = new Random();
        this.nums = nums;
        // this.count = 0;
        
    }
    
    public int pick(int target) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]) count++;
        }
        int index = rnd.nextInt(count);
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]){
                if(index == 0){
                    return i;
                }
                else{
                    index--;
                }
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
