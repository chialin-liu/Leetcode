class Solution {
    public void wallsAndGates(int[][] room) {
        if(room == null || room.length == 0 || room[0].length == 0) return;
        for(int i = 0; i < room.length ; i++){
            for(int j = 0; j < room[0].length; j++){
                if(room[i][j] == 0){
                    dfs(room, i, j, 0);
                }
            }
        }
    }
    public void dfs(int [][]room, int i, int j, int dist){
        if(i < 0 || j < 0 || i >= room.length || j >= room[0].length || room[i][j] < dist) return;
        room[i][j] = dist;
        dfs(room, i + 1, j, dist + 1);
        dfs(room, i - 1, j, dist + 1);
        dfs(room, i, j + 1, dist + 1);
        dfs(room, i, j - 1, dist + 1);
    }
}
