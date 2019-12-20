class Solution {
    public int maxProduct(int[] nums) {
        int imax = nums[0];
        int imin = nums[0];
        int res = nums[0];
        for(int i = 1;  i < nums.length; i++){
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);
            res = Math.max(res, imax);
        }
        return res;
    }
}
