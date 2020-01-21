class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int time = 0;
        int [][]dist = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int []cur = queue.poll();
                
                for(int k = 0; k < 4; k++){
                    int newX = cur[0] + dist[k][0];
                    int newY = cur[1] + dist[k][1];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1){
                        queue.offer(new int[]{newX, newY});
                        grid[newX][newY] = 2;
                    }
                }
            }
            if(!queue.isEmpty()) time++;
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }
}
