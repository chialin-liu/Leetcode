class Solution {
    public void nextPermutation(int[] nums) {
        int firstSmall = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                firstSmall = i;
                break;
            }
        }
        if(firstSmall == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLarge = -1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > nums[firstSmall]){
                firstLarge= i;
                break;
            }
        }
        int temp = nums[firstSmall];
        nums[firstSmall] = nums[firstLarge];
        nums[firstLarge] = temp;
        reverse(nums, firstSmall + 1, nums.length - 1);
    }
    public void reverse(int []nums, int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
