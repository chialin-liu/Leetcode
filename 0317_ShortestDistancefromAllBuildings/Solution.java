class Solution {
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int totalNum = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int [][]dist = new int [m][n];
        int [][]num = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    totalNum++;
                    bfs(grid, i, j, dist, num);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(num[i][j] == totalNum && grid[i][j] == 0){
                    res = Math.min(dist[i][j], res);
                }
            }
        }
        return res == Integer.MAX_VALUE? -1 : res;
    }
    public void bfs(int [][]grid, int row, int col, int [][]dist, int [][]num){
        Queue<Point> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        queue.offer(new Point(col, row));
        int [] dx = {0, 0, 1, -1};
        int [] dy = {1, -1,0,  0};
        visited[row][col] = true;
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++;
            for(int i = 0; i < size; i++){
                Point cur = queue.poll();
                Point newP = new Point(0, 0);
                for(int ii = 0; ii < 4; ii++){
                    newP.x = cur.x + dx[ii];
                    newP.y = cur.y + dy[ii];
                    if(newP.x < n && newP.x >= 0 && newP.y < m && newP.y >= 0 && grid[newP.y][newP.x] == 0 && !visited[newP.y][newP.x]){
                        visited[newP.y][newP.x] = true;
                        num[newP.y][newP.x]++;
                        dist[newP.y][newP.x] += distance;
                        queue.offer(new Point(newP.x, newP.y));
                    }
                }
            }
        }
    }
}
