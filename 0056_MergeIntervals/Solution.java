class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int []>(){
            public int compare(int []a, int []b){
                return a[0] - b[0];
            }
        });
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return intervals;
        int [][] res = new int [intervals.length][2];
        int start = intervals[0][0];
        int end = intervals[0][1];
        int index = 0;
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] <= end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
            else{
                res[index][0] = start;
                res[index][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                index++;
            }
        }        
        res[index][0] = start;
        res[index][1] = end;
        index++;
        int [][] finalRes = new int[index][2];
        for(int i = 0; i < index; i++){
            finalRes[i][0] = res[i][0];
            finalRes[i][1] = res[i][1];
        }
        return finalRes;
    }
}
