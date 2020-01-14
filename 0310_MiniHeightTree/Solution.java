class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(new ArrayList<>());
        }
        for(int []edge: edges){
            res.get(edge[0]).add(edge[1]);
            res.get(edge[1]).add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(res.get(i).size() <= 1){
                leaves.add(i);
            }
        }
        while(n > 2){
            n = n - leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer leaf: leaves){
                int root = res.get(leaf).get(0);
                res.get(root).remove(leaf);
                if(res.get(root).size() == 1){
                    newLeaves.add(root);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
