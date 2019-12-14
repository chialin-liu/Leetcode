class Solution {
    public int missingElement(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            int count = nums[mid] - nums[start] - 1 - (mid - start - 1);
            if(count >= k){
                end = mid;
            }
            else{
                start = mid;
                k = k - count;
            }
        }
        if(nums[end] - nums[start] - 1 < k){
            k = k - (nums[end] - nums[start] - 1);
            return nums[end] + k;
        }
        return nums[start] + k;
    }
}
