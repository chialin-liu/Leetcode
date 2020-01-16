class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < graph.length; i++){
            for(int len = 0; len < graph[i].length; len++){
                list.get(i).add(graph[i][len]);
            }
        }
        int []color = new int[graph.length];
        Set<Integer> visited = new HashSet<>();
        boolean res = true;
        for(int i = 0; i < graph.length; i++){
            if(color[i] == 0){
                res = dfs(color, i, 1, list);
                if(res == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int []color, int cur, int value, List<List<Integer>> list){
        if(color[cur] != 0){
            return color[cur] == value;
        }
        color[cur] = value;
        for(int neighbor: list.get(cur)){
            boolean res = dfs(color, neighbor, -value, list);
            if(res == false){
                return false;
            }
        }
        return true;
    }
}
