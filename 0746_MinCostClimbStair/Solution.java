class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int onestep = cost[1];
        int twostep = cost[0];
        int last = 0;
        for(int i = 2; i < cost.length; i++){
            last = Math.min(onestep, twostep) + cost[i];
            twostep = onestep;
            onestep = last;
        }
        return Math.min(onestep, twostep);
    }
}
