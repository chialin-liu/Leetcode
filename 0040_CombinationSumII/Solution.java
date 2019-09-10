public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null){
            res.add(new ArrayList<>());
            return res;
        }
        Arrays.sort(candidates);
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
            if(i != start && (candidates[i] == candidates[i - 1])) continue;
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
