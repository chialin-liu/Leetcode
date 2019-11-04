class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        for(int i = 0; i < nums.length; i++){
            int down = nums[i] - 1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            int up = nums[i] + 1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            res = Math.max(res, up - down - 1);
        }
        return res;
    }
}
