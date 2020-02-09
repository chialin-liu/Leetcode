class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, new Comparator<>(){
            public int compare(int []a, int []b){
                return a[0] - b[0];
            }
        });
        int end = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                end = Math.min(end, intervals[i][1]);
                res++;
            }
            else{
                end = intervals[i][1];
            }
        }
        return res;
    }
}
