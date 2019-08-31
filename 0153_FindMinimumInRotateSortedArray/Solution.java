class Solution {
    public int findMin(int[] nums) {
       if(nums == null || nums.length == 0){
           return -1;
       } 
        int end = nums.length - 1;
        int start = 0;
        int mid;
        int endValue = nums[end];
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == endValue){
                end = mid;
            }
            else if(nums[mid] < endValue){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(nums[start] <= endValue){
            return nums[start];
        }
        else{
            return nums[end];
        }
    }
}
