class Solution {
    public int lengthOfLIS(int[] nums) {
        int []f = new int [nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            f[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        return max;        
    }
}
