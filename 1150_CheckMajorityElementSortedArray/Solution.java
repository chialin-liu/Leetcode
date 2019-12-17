class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int first = firstTarget(nums, target);
        int end = lastTarget(nums, target);
        if(first == -1 || end == -1) return false;
        int number = end - first + 1;
        if(number > nums.length / 2) return true;
        else return false;
    }
    public int firstTarget (int []nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }
        else if(nums[end] == target){
            return end;
        }
        else{
            return -1;
        }
    }
    public int lastTarget (int []nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                start = mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(nums[end] == target){
            return end;
        }
        else if(nums[start] == target){
            return start;
        }
        else{
            return -1;
        }
    }
}
