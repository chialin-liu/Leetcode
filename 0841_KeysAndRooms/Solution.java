class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<List<Integer>> list = new ArrayList<>();
        int n = rooms.size();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int neighbor: rooms.get(i)){
                list.get(i).add(neighbor);
            }
        }
        boolean []visited = new boolean [n];
        int total = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                total++;
                dfs(i, visited, list);
            }
        }
        return total == 1;
    }
    public void dfs(int cur, boolean []visited, List<List<Integer>> list){
        if(visited[cur]){
            return;
        }
        visited[cur] = true;
        for(int neighbor: list.get(cur)){
            dfs(neighbor, visited, list);
        }
    }
}
