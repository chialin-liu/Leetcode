class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] res = new int [intervals.length + 1][2];
        if(newInterval == null || newInterval.length == 0) return intervals;
        // if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) return  intervals;
        
        int i = 0;
        int j = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
            i++;
            j++;
        }
        int start = newInterval[0];
        int end = newInterval[1];
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }
        res[j][0] = start;
        res[j][1] = end;
        j++;
        while(i < intervals.length){
            res[j][0] = intervals[i][0];
            res[j][1] = intervals[i][1];
            i++;
            j++;
        }
        int [][] finalRes = new int[j][2];
        for(int ii = 0; ii < j; ii++){
            finalRes[ii][0] = res[ii][0];
            finalRes[ii][1] = res[ii][1];
        }
        return finalRes;
            
    }
}
