class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        if(grid[0][0] == 0){
            queue.offer(new int[]{0, 0});
        }
        int [][]dist = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int []cur = queue.poll();
                if(cur[0] == (grid.length - 1) && cur[1] == grid[0].length - 1){
                    return time + 1;
                }
                for(int j = 0; j < 8; j++){
                    int newX = cur[0] + dist[j][0];
                    int newY = cur[1] + dist[j][1];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 0){
                        grid[newX][newY] = 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
