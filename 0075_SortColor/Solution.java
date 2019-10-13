class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int zero = -1;
        int two = nums.length;
        for(int i = 0; i < two;){
            if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 2){
                two--;
                int temp = nums[i];
                nums[i] = nums[two];
                nums[two] = temp;
            }
            else if(nums[i] == 0){
                zero++;
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                i++;
            }
        }
    }
}
