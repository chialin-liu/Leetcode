class Solution {
    public int combinationSum4(int[] nums, int target) {
int []f = new int [target + 1];
        int n = nums.length;
        f[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < n; j++){
                if(i >= nums[j]){
                    f[i] = f[i] + f[i - nums[j]];
                }
                 
            }
        }
        return f[target];        
    }
}
