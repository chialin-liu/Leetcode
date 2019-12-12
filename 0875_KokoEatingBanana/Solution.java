class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        if(piles == null || piles.length == 0) return 0;
        int start = 1;
        int maxPile = 0;
        for(int pile: piles){
            maxPile = Math.max(maxPile, pile);
        }
        int end = maxPile;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(canEat(piles, mid, H)){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(canEat(piles, start, H)){
            return start;
        }
        else{
            return end;
        }
    }
    public boolean canEat(int []piles, int k, int H){
        int hour = 0;
        for(int pile: piles){
            hour += pile / k;
            if(pile % k != 0){
                hour++;
            }
        }
        return hour <= H;
    }
}
