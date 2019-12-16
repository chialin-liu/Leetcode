class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int end = max + 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isValid(nums, mid, threshold)){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(isValid(nums, start, threshold)){
            return start;
        }
        else{
            return end;
        }
        
    }
    public boolean isValid(int []nums, int mid, int threshold){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % mid != 0){
                count += (nums[i] / mid) + 1;
            }
            else{
                count += nums[i] / mid;
            }
        }
        return count <= threshold;
    }
}
