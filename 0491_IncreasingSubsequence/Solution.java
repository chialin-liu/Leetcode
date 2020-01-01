class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean []visit = new boolean[nums.length];
        Set<List<Integer>> set = new HashSet<>();
        dfs(set, new ArrayList<>(), nums, 0, visit);
        for(List<Integer> list: set){
            res.add(new ArrayList<>(list));
        }
        return res;
    }
    public void dfs(Set<List<Integer>> res, List<Integer> list, int []nums, int pos, boolean []visit){
        
        if(list.size() > 1 && list.get(list.size() - 1) >= list.get(list.size() - 2)){
            res.add(new ArrayList<>(list));
            
        }
        else if(list.size() > 1 && list.get(list.size() - 1) < list.get(list.size() - 2)){
            return;
        }
            
        for(int i = pos; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && visit[i - 1] == false) continue;
            if(visit[i] == false){
                list.add(nums[i]);
                visit[i] = true;
                dfs(res, list, nums, i + 1, visit);
                visit[i] = false;
                list.remove(list.size() - 1);                
            }

        }
        
    }
}
