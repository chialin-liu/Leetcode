class Solution {
    public int arrayNesting(int[] nums) {
        int start = 0;
        int res = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            start = i;
            count = 0;
            while(nums[start] != -1){
                int indx = start;
                count++;
                start = nums[start];
                nums[indx] = -1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
