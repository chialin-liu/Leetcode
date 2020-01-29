class Solution {
    class Pair{
        int row;
        int col;
        int height;
        public Pair(int r, int c, int h){
            this.row = r;
            this.col = c;
            this.height = h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.height - b.height;
            }
        });
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean [][]visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    visited[i][j] = true;
                    queue.offer(new Pair(i, j, heightMap[i][j]));
                }
            }
        }
        int res  = 0;
        int max = 0;
        int [][]dist = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair cur = queue.poll();
                max = Math.max(cur.height, max);
                for(int j = 0; j < 4; j++){
                    int newX = cur.row + dist[j][0];
                    int newY = cur.col + dist[j][1];
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        if(heightMap[newX][newY] < max){
                            res += max - heightMap[newX][newY];
                        }
                        queue.offer(new Pair(newX, newY, heightMap[newX][newY]));
                    }
                }
            }
        }
        return res;
    }
}
