class Solution {
    class Point{
        int val;
        int row;
        int col;
        public Point(int v, int r, int c){
            this.val = v;
            this.row = r;
            this.col = c;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                return p1.val - p2.val;
            }
        });
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            List<Integer> list = nums.get(i);
            Point newP = new Point(list.get(0), i, 0);
            queue.offer(newP);
            max = Math.max(max, list.get(0));
        }
        int range = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        while(queue.size() == nums.size()){
            Point cur = queue.poll();
            if(range > max - cur.val){
                range = max - cur.val;
                start = cur.val;
                end = max;
            }
            int row = cur.row;
            if(cur.col + 1 < nums.get(row).size()){
                Point newP = new Point(nums.get(row).get(cur.col + 1), row, cur.col + 1);
                queue.offer(newP);
                max = Math.max(nums.get(row).get(cur.col + 1), max);
            }
        }
        return new int[]{start, end};
    }
}
