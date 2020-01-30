class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int []> queue = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int []a, int []b){
                return a[2] - b[2];
            }
        });
        int m = forest.size();
        int n = forest.get(0).size();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(forest.get(i).get(j) > 1){
                    queue.offer(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        int []start = new int[2];
        int sum = 0;
        while(!queue.isEmpty()){
            int []cur = queue.poll();
            int step = getmin(cur, start, forest);
            if(step == -1){
                return -1;
            }
            else{
                sum += step;
            }
            start[0] = cur[0];
            start[1] = cur[1];
        }
        return sum;
    }
    public int getmin(int []cur, int []start, List<List<Integer>> forest){
        Queue<int []> queue = new LinkedList<>();
        int m = forest.size();
        int n = forest.get(0).size();
        boolean [][]visited = new boolean[m][n];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int step = 0;
        int [][]dist = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int []now = queue.poll();
                if(now[0] == cur[0] && now[1] == cur[1]){
                    return step;
                }
                for(int j = 0; j < 4; j++){
                    int newX = now[0] + dist[j][0];
                    int newY = now[1] + dist[j][1];
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY] && forest.get(newX).get(newY) != 0){
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
