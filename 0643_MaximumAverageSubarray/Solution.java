class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double res = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
            res = sum;
        }
        for(int i = k; i < nums.length; i++){
            sum = sum + nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }
}
