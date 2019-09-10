class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, nums, 0, new ArrayList<>());
        return res;
    }
    public void helper(List<List<Integer>> res, int []nums, int index, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++){
            if(i != 0 && i != index && (nums[i] == nums[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            helper(res, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
