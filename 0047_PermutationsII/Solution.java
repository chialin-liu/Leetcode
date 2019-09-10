public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    private void helper(int []nums, List<List<Integer>> res, List<Integer> list, boolean []used){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || i > 0 && (nums[i] == nums[i -1]) && !used[i - 1]){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            helper(nums, res, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
};
