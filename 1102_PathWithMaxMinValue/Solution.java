class Solution {
    public int maximumMinimumPath(int[][] A) {
        PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int []>(){
            public int compare(int []a, int []b){
                return b[0] - a[0];
            }
        });
        queue.offer(new int[]{A[0][0], 0, 0});
        A[0][0] = -1;
        int max = Integer.MAX_VALUE;
        int [][]arr = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()){
            int []cur = queue.poll();
            int row = cur[1];
            int col = cur[2];
            int element = cur[0];
            max = Math.min(max, element);
            if(row == A.length - 1 && col == A[0].length - 1){
                return max;
            }
            for(int i = 0; i < 4; i++){
                int newRow = row + arr[i][0];
                int newCol = col + arr[i][1];
                if(newRow >= 0 && newRow <= A.length - 1 && newCol >= 0 && newCol <= A[0].length - 1 && A[newRow][newCol] >= 0){
                    queue.offer(new int[]{A[newRow][newCol], newRow, newCol});
                    A[newRow][newCol] = -1;
                }
            }
        }
        return -1;
    }
}
