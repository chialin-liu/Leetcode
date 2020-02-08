class Solution {
    public int findKthLargest(int[] nums, int k) {
        int val = quickSelect(nums, 0, nums.length - 1, k);
        return val;
    }
    public int quickSelect(int []nums, int start, int end, int k){
        if(start == end){
            return nums[start];
        }
        int i = start;
        int j = end;
        int pivot = nums[(start + end) / 2];
        while(i <= j){
            while(i <= j && nums[i] > pivot){
                i++;
            }
            while(i <= j && nums[j] < pivot){
                j--;
            }
            if(i <= j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if(start + (k - 1) <= j){
           return quickSelect(nums, start, j, k);
        }
        else if(start + (k - 1) >= i){
            return quickSelect(nums, i, end, k - (i - start));
        }
        else{
            return nums[j + 1];
        }
    }
}
