class Solution {
    public int snakesAndLadders(int[][] board) {
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(1);
        int n = board[0].length;
        boolean []visited = new boolean[n * n + 1];
        visited[1] = true;
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                if(cur == n * n){
                    return step;
                }
                for(int j = 1; j <= 6; j++){
                    int next = cur + j;
                    if(next > n * n) break;
                    int []nextArr = getPosition(next, board);
                    next = board[nextArr[0]][nextArr[1]] == -1? next: board[nextArr[0]][nextArr[1]];
                    if(!visited[next] ){
                        queue.offer(next);
                        visited[next] = true;
                    }
                    
                }
            }
            step++;
        }
        return -1;
    }
    public int[] getPosition(int num, int [][]board){
        int m = board.length;
        int n = board[0].length;
        int row = (num - 1) / n;
        int col = (num - 1) % n;
        if(row % 2 == 1){
            col = n - 1 - col;
        }
        row = m - 1 - row;
        return new int[]{row, col};
    }
}
