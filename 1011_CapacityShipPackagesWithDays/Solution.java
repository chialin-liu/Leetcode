class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if(weights == null || weights.length == 0){
            return 0;
        }
        int end = 0;
        int start = 0;
        for(int i = 0; i < weights.length; i++){
            end += weights[i];
            start = Math.max(start, weights[i]);
        }
        // int start = 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(countDay(weights, mid) <= D){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(countDay(weights, start) <= D){
            return start;
        }
        else{
            return end;
        }
    }
    public int countDay(int []weights, int capacity){
        int day = 1;
        int sum = 0;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            if(sum > capacity){
                day++;
                sum = weights[i];
            }
        }
        return day;
    }
}
