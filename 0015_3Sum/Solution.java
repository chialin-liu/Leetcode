class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int a, b, c = 0;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(c = 0; c <= nums.length - 3; c++){
            int left = c + 1;
            int right = nums.length - 1;
            int target = -nums[c];
            
            if(c >= 1 && nums[c] == nums[c - 1]) continue;
            while(left < right){
                List<Integer> list = new ArrayList<>();
                if(nums[left] + nums[right] == target){
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.add(nums[c]);
                    res.add(list);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if(nums[left] + nums[right] < target){
                    left++;
                }
                else{
                    right--;
                }
            }
            
        }
        return res;
    }
}
