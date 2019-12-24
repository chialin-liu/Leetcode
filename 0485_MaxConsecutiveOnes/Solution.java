class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0, j = 0; i < nums.length ;i++){
            if(nums[i] == 0){
                while(i < nums.length && nums[i] == 0){
                    i++;
                }

                j = i;
                i--;    
            }
            max = Math.max(max, i - j + 1);
        }
        return max == Integer.MIN_VALUE? 0: max;
    }
}
