class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int []sum = new int[nums.length + 1];
        for(int i = 1; i < sum.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < sum.length - 1; i++){
            int right = binary(i + 1, sum.length - 1, sum, sum[i] + s);
            if(right == Integer.MAX_VALUE) continue;
            min = Math.min(right - i, min);
        }
        return min == Integer.MAX_VALUE? 0: min;
        
    }
    public int binary(int start, int end, int []sum, int target){
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(sum[mid] >= target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(sum[start] >= target){
            return start;
        }
        else if(sum[end] >= target){
            return end;
        }
        else{
            return Integer.MAX_VALUE;
        }
    }
}
