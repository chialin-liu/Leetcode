class Solution {
    public int shortestBridge(int[][] A) {
        Queue<int []> queue = new LinkedList<>();
        boolean [][]visited = new boolean[A.length][A[0].length];
        boolean found = false;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(found == true){
                    break;
                }
                if(A[i][j] == 1){
                    dfs(A, visited, i, j, queue);
                    found = true;
                    break;
                }
            }
        }
        int [][]dist = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int []cur = queue.poll();
                for(int j = 0; j < 4; j++){
                    int newX = cur[0] + dist[j][0];
                    int newY = cur[1] + dist[j][1];
                    if(newX >= 0 && newX < A.length && newY >= 0 && newY < A[0].length && !visited[newX][newY]){
                        if(A[newX][newY] == 1){
                            return time;
                        }
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            time++;
        }
        return -1;
    }
    public void dfs(int [][]A, boolean [][]visited, int row, int col, Queue<int []> queue){
        if(row < 0 || row >= A.length || col < 0 || col >= A[0].length || A[row][col] == 0 || visited[row][col]){
            return;
        }
        visited[row][col] = true;
        queue.offer(new int[]{row, col});
        dfs(A, visited, row + 1, col, queue);
        dfs(A, visited, row - 1, col, queue);
        dfs(A, visited, row, col + 1, queue);
        dfs(A, visited, row, col - 1, queue);
    }
}
