class Solution {
    int res;
    public int treeDiameter(int[][] edges) {
        res = 0;
        int point = edges.length + 1;
        List<Integer> [] adjacent = new ArrayList[point];
        for(int i = 0; i < point; i++){
            adjacent[i] = new ArrayList<>();
        }
        for(int []edge: edges){
            adjacent[edge[0]].add(edge[1]);
            adjacent[edge[1]].add(edge[0]);
        }
        int temp = count(0, -1, adjacent);
        return Math.max(res, temp);
    }
    public int count(int root, int parent, List<Integer> []adjacent){
        int maxDepthOfAllChildren = 0;
        int secondDepthOfAllChildren = 0;
        for(int child: adjacent[root]){
            if(child != parent){
                int depth = count(child, root, adjacent);
                if(depth > maxDepthOfAllChildren){
                    secondDepthOfAllChildren = maxDepthOfAllChildren;
                    maxDepthOfAllChildren = depth;
                    
                }
                else if(depth > secondDepthOfAllChildren){
                    secondDepthOfAllChildren = depth;
                }
            }
        }
        res = Math.max(res, maxDepthOfAllChildren + secondDepthOfAllChildren);
        return maxDepthOfAllChildren + 1;
    }
}
