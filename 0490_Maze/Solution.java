class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length;
        int col = maze[0].length;
        boolean [][]visited = new boolean[row][col];
        if(dfs(start, destination, maze, visited)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean dfs(int []start, int []destination, int [][]maze, boolean [][]visited){
        if(visited[start[0]][start[1]]) return false;
        visited[start[0]][start[1]] = true;
        if(start[0] == destination[0] && start[1] == destination[1]) return true;
        if(rolling(start, destination, visited, 1, 0, maze)) return true;
        if(rolling(start, destination, visited, -1, 0, maze)) return true;
        if(rolling(start, destination, visited, 0, 1, maze)) return true;
        if(rolling(start, destination, visited, 0, -1, maze)) return true;
        return false;
    }
    public boolean rolling(int []start, int []destination, boolean [][]visited, int rowInc, int colInc, int [][]maze){
        int row = start[0];
        int col = start[1];
        while(row + rowInc < maze.length && col + colInc < maze[0].length && row + rowInc >= 0 && col + colInc >= 0 && maze[row + rowInc][col + colInc] != 1){
            row = row + rowInc;
            col = col + colInc;
        }
        return dfs(new int[]{row, col}, destination, maze, visited);
    }
}
