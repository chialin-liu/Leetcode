class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]));
        for(int [] list: points){
            queue.offer(list);
            if(queue.size() > K){
                queue.poll();
            }
        }
        int [][] res = new int [K][2];
        if(points.length == 0 || points == null) {
            return res;
        }
        for(int i = 0; i < K; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
