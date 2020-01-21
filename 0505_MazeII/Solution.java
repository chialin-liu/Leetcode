class Solution {
    class Point{
        int row;
        int col;
        int len;
        public Point(int r, int c, int l){
            this.row = r;
            this.col = c;
            this.len = l;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1], 0));
        int [][]dist = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int [][]len = new int[maze.length][maze[0].length];
        // Set<String> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                len[i][j] = Integer.MAX_VALUE;
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point cur = queue.poll();
                int x = cur.row;
                int y = cur.col;
                if(len[x][y] <= cur.len) continue;
                len[x][y] = cur.len;
                if(x == destination[0] && y == destination[1]){
                    min = Math.min(min, cur.len);
                }
                // set.add(String.valueOf(x) + "_" + String.valueOf(y));
                for(int k = 0; k < 4; k++){
                    x = cur.row;
                    y = cur.col;
                    int length = cur.len;
                    while(x + dist[k][0] < maze.length && x + dist[k][0] >= 0 && y + dist[k][1] < maze[0].length && y + dist[k][1] >= 0 && maze[x + dist[k][0]][y + dist[k][1]] == 0){
                        x = x + dist[k][0];
                        y = y + dist[k][1];
                        length++;
                    }
                    String newStr = String.valueOf(x) + "_" + String.valueOf(y);
                    // if(!set.contains(newStr)){
                        queue.offer(new Point(x, y, length));
                        // set.add(newStr);
                    // }
                }
            }
        }
        return min == Integer.MAX_VALUE? -1: min;
    }
}
