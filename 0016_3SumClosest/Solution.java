class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i <= nums.length - 3; i++){
            
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
                if(Math.abs(sum - target) < diff){
                    res = sum;
                    diff = Math.abs(sum - target);
                }
            }
        }
        return res;
        
    }
}
