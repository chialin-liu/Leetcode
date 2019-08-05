public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    
    public int numIslands(boolean[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == true){
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void bfs(boolean [][]grid, int y, int x){
        int []dx = {1, -1, 0, 0 };
        int []dy = {0, 0 , 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        while(!queue.isEmpty()){
            Point cur_p = queue.poll();
            Point new_p = new Point(0, 0);
            for(int index = 0; index < 4; index++){
                new_p.x = cur_p.x + dx[index];
                new_p.y = cur_p.y + dy[index];
                if(new_p.x >= 0 && new_p.x < grid[0].length && new_p.y >= 0 && new_p.y < grid.length && grid[new_p.y][new_p.x]){
                    queue.offer(new Point(new_p.x, new_p.y));
                    grid[new_p.y][new_p.x] = false;
                }
            }
        }
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
