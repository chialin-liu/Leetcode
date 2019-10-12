class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        int [] startArr = new int [intervals.length];
        int [] endArr = new int [intervals.length];
        for(int i = 0; i < intervals.length; i++){
            startArr[i] = intervals[i][0];
            endArr[i] = intervals[i][1];
        }
        Arrays.sort(startArr);
        Arrays.sort(endArr);
        int res = 0;
        int endIdx = 0;
        for(int i = 0; i < intervals.length; i++){
            if(startArr[i] < endArr[endIdx]){
                res++;
            }
            else{
                endIdx++;
            }
        }
        return res;        
    }
}
