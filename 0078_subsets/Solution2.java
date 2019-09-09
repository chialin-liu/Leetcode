class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }
    public void dfs(int [] nums, List<List<Integer>> res, List<Integer> list, int index){
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[index]);
        dfs(nums, res, list, index + 1);
        
        list.remove(list.size() - 1);
        dfs(nums, res, list, index + 1);
    }
}
