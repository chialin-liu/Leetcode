class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
                else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int [][]dist = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int []cur = queue.poll();
                for(int j = 0; j < 4; j++){
                    int newX = cur[0] + dist[j][0];
                    int newY = cur[1] + dist[j][1];
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[cur[0]][cur[1]] + 1){
                        matrix[newX][newY] = matrix[cur[0]][cur[1]] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return matrix;
    }
}
