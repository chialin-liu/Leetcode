class Solution {
    TreeMap<Integer, Integer> map;
    int [][]rects;
    Random rnd;
    int area;
    public Solution(int[][] rects) {
        this.rnd = new Random();
        this.rects = rects;
        this.map = new TreeMap<>();
        this.area = 0;
        for(int i = 0; i < rects.length; i++){
            int [] rect = rects[i];
            area += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(area, i);
        }
    }
    
    public int[] pick() {
        int target = rnd.nextInt(area) + 1;
        int index = map.ceilingKey(target);
        int [] rect = rects[map.get(index)];
        int x = rect[0] + rnd.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + rnd.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
