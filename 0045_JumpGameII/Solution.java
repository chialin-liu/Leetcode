class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int res = 0;
        int cur = 0;
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++){
            max = Math.max(max, i + nums[i]);
            if(i == cur){
                res++;
                cur = max;
            }
        }
        return res;
    }
}
