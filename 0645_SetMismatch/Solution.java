class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean []visited = new boolean[nums.length + 1];
        int dup = 0;
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                visited[nums[i]] = true;
            }
            else{
                dup = nums[i];
            }
        }
        int err = 0;
        for(int i = 1; i <= nums.length; i++){
            if(!visited[i]){
                err = i;
            }
        }
        return new int[]{dup, err};
    }
}
