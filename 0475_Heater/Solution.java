class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int heater: heaters){
            set.add(heater);
        }
        int res = 0;
        for(int house: houses){
            int dist1 = set.ceiling(house) == null? Integer.MAX_VALUE: Math.abs(set.ceiling(house) - house);
            int dist2 = set.floor(house) == null? Integer.MAX_VALUE: Math.abs(set.floor(house) - house);
            res = Math.max(res, Math.min(dist1, dist2));
        }
        return res;
    }
}
