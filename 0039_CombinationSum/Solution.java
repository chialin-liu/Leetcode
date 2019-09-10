public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null){
            res.add(new ArrayList<>());
            return res;
        }
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int []candidates, int target, int start){
        if(target < 0) return ;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        } 
        for(int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
