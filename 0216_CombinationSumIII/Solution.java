class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0) return res;
        helper(res, k, n, new ArrayList<Integer>(), 1);
        return res;
    }
    public void helper(List<List<Integer>> res, int k, int n, List<Integer> list, int start){
        if(list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= 9; i++){
            if(list.contains(i)) continue;
            list.add(i);
            helper(res, k, n - i, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
