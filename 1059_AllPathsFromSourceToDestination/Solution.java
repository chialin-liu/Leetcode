class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int []edge: edges){
            list.get(edge[0]).add(edge[1]);
        }
        boolean []state = new boolean[n];
        boolean res = dfs(source, destination, list, state);
        return res;
    }
    public boolean dfs(int source, int desti, List<List<Integer>> list, boolean []state){
        if(state[source] == true) return false;
        if(list.get(source).contains(source)){
            return false;
        }
        if(list.get(source).size() == 0){
            if(source == desti) return true;
            else return false;
        }
        state[source] = true;
        List<Integer> neighbors = list.get(source);
        boolean res = false;
        for(int neighbor: neighbors){
            res = dfs(neighbor, desti, list, state);
            if(res == false){
                return false;
            }
        }
        state[source] = false;
        return res;
    }
}
