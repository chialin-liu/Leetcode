class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[mid] < nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
            else if(nums[mid] > nums[end]){
            // else{
                if(target >= nums[start] && target < nums[mid]){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            else{
                end--;
            }
        }
        if(nums[start] == target){
            return true;
        }
        else if(nums[end] == target){
            return true;
        }
        else{
            return false;
        }
    }
}
