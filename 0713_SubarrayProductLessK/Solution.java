class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int product = 1;
        while(end < nums.length){
            product = product * nums[end];
            while(start <= end && product >= k){
                product = product / nums[start];
                start++;
            }
            sum += end - start + 1;
            end++;
        }
        return sum;
    }
}
