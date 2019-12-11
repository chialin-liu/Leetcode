class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int []res = new int [intervals.length];
        for(int i = 0; i < intervals.length; i++){
            map.put(intervals[i][0], i);
        }
        for(int i = 0; i < intervals.length; i++){
            Integer ceilingKey = map.ceilingKey(intervals[i][1]);
            res[i] = (ceilingKey == null)? -1: map.get(ceilingKey);
        }
        return res;
    }
}
