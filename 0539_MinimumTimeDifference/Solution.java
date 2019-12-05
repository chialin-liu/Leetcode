class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints == null) return 0;
        boolean []time = new boolean[24*60];
        for(String cur: timePoints){
            String []str = cur.split(":");
            int hour = Integer.valueOf(str[0]);
            int minute = Integer.valueOf(str[1]);
            if(time[hour * 60 + minute] == true){
                return 0;
            }
            time[hour * 60 + minute] = true;
        }
        int first = -1;
        int pre = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < time.length; i++){
            if(time[i] == true){
                if(first == -1){
                    first = i;
                }
                else{
                    res = Math.min(res, i - pre);
                }
                pre = i;
            }
        }
        res = Math.min(res, first + 24 * 60 - pre);
        return res;
    }
}
