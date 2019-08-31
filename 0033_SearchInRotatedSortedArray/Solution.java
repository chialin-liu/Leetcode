class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[start] <= nums[mid]){
                if((target < nums[mid]) && (target >= nums[start])){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            else if(nums[end] >= nums[mid]){
                if((target >= nums[mid]) && (target <= nums[end])){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        if(nums[start] == target){
            return start;
        }
        else if(nums[end] == target){
            return end;
        }
        return -1;
    }
}
