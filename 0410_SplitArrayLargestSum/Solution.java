class Solution {
    public int splitArray(int[] nums, int m) {
        long left = 0;
        long right = 0;
        for(int i = 0; i < nums.length; i++){
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        long res = 0;
        while(left <= right){
            long mid = left + (right - left) / 2;
            if(bs(nums, m, mid)){
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return (int) res;
    }
    public boolean bs(int []nums, int m, long target){
        int count = 1;
        long sum = 0;
        for(int num: nums){
            sum += num;
            if(sum > target){
                count++;
                sum = num;
            }
        }
        return count <= m;
    }
}
