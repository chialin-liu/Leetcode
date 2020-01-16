class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                list.get(i).add(graph[i][j]);
            }
        }
        int []visited = new int[graph.length];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            boolean com = dfs(i, visited, list);
            if(com == true){
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(int cur, int []visited, List<List<Integer>> list){
        if(visited[cur] != 0){
            return visited[cur] == 2;
        }
        visited[cur] = 1;
        for(int neighbor: list.get(cur)){
            boolean res = dfs(neighbor, visited, list);
            if(res == false){
                return false;
            }
        }
        visited[cur] = 2;
        return true;
    }
}
